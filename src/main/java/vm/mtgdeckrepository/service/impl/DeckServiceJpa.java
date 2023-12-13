package vm.mtgdeckrepository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import vm.mtgdeckrepository.dao.CardInDeckRepository;
import vm.mtgdeckrepository.dao.DeckRepository;
import vm.mtgdeckrepository.dao.PlayerRepository;
import vm.mtgdeckrepository.domain.CardInDeck;
import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.domain.Player;
import vm.mtgdeckrepository.dto.CardInDeckDTO;
import vm.mtgdeckrepository.error.EntityMissingException;
import vm.mtgdeckrepository.service.DeckService;

import java.util.List;
import java.util.Optional;

@Service
public class DeckServiceJpa implements DeckService {

    @Autowired
    private DeckRepository deckRepo;

    @Autowired
    private CardInDeckRepository cardInDeckRepo;

    @Override
    public Deck createDeck(Player creator, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard) {
        Assert.hasText(deck_name, "Deck name must be set.");
        Assert.hasText(format, "Format must be set.");

        String[] legalFormats = {"Standard", "Pioneer", "Modern", "Pauper"};
        boolean correctFormat = false;
        for (String legalFormat : legalFormats) {
            if (legalFormat.equals(format)) {
                correctFormat = true;
            }
        }
        if (!correctFormat) {
            throw new IllegalArgumentException("Format not supported.");
        }

        String[] basicLands = {"Plains", "Island", "Swamp", "Mountain", "Forest"};

        int mainDeckCount = 0;
        for (CardInDeckDTO card : main_deck) {
            Assert.hasText(card.getCard_name(), "Card names must be set.");
            if (card.getQuantity() < 1) {
                throw new IllegalArgumentException("Card quantity can't be less than 1.");
            } else if (card.getQuantity() > 4) {
                boolean isBasicLand = false;
                for (String basicLand : basicLands) {
                    if (basicLand.equals(card.getCard_name())) {
                        isBasicLand = true;
                    }
                }
                if (!isBasicLand) {
                    throw new IllegalArgumentException("Card quantity can't be more than 4 for all cards except basic lands.");
                }
            }
            mainDeckCount += card.getQuantity();
        }

        if (mainDeckCount < 60) {
            throw new IllegalArgumentException("Main deck can't have less than 60 cards.");
        }

        int sideboardCount = 0;
        for (CardInDeckDTO card : sideboard) {
            Assert.hasText(card.getCard_name(), "Card names must be set.");
            if (card.getQuantity() < 1) {
                throw new IllegalArgumentException("Card quantity can't be less than 1.");
            } else if (card.getQuantity() > 4) {
                boolean isBasicLand = false;
                for (String basicLand : basicLands) {
                    if (basicLand.equals(card.getCard_name())) {
                        isBasicLand = true;
                    }
                }
                if (!isBasicLand) {
                    throw new IllegalArgumentException("Card quantity can't be more than 4 for all cards except basic lands.");
                }
            }
            sideboardCount += card.getQuantity();
        }

        if (sideboardCount > 15) {
            throw new IllegalArgumentException("Sideboard can't have more than 15 cards.");
        }

        Deck deck = new Deck(creator, deck_name, format);

        Deck newDeck = deckRepo.save(deck);

        for (CardInDeckDTO card : main_deck) {
            cardInDeckRepo.save(new CardInDeck(newDeck, card.getCard_name(), card.getQuantity(), true));
        }

        for (CardInDeckDTO card : sideboard) {
            cardInDeckRepo.save(new CardInDeck(newDeck, card.getCard_name(), card.getQuantity(), false));
        }

        Deck newNewDeck = deckRepo.findById(newDeck.getDeck_id()).get();

        return newNewDeck;
    }

    @Override
    public List<Deck> getAll() {
        return deckRepo.findAll();
    }

    @Override
    public Deck getById(long id) {
        Optional<Deck> deck = deckRepo.findById(id);
        if (deck.isEmpty()) {
            throw new EntityMissingException("Deck not found.");
        }
        return deck.get();
    }

    @Override
    public Deck updateDeck(long id, String deck_name, String format, List<CardInDeckDTO> main_deck, List<CardInDeckDTO> sideboard) {
        Optional<Deck> deckCheck = deckRepo.findById(id);
        if (deckCheck.isEmpty()) {
            throw new EntityMissingException("Deck not found.");
        }

        String[] basicLands = {"Plains", "Island", "Swamp", "Mountain", "Forest"};

        int mainDeckCount = 0;
        for (CardInDeckDTO card : main_deck) {
            Assert.hasText(card.getCard_name(), "Card names must be set.");
            if (card.getQuantity() < 1) {
                throw new IllegalArgumentException("Card quantity can't be less than 1.");
            } else if (card.getQuantity() > 4) {
                boolean isBasicLand = false;
                for (String basicLand : basicLands) {
                    if (basicLand.equals(card.getCard_name())) {
                        isBasicLand = true;
                    }
                }
                if (!isBasicLand) {
                    throw new IllegalArgumentException("Card quantity can't be more than 4 for all cards except basic lands.");
                }
            }
            mainDeckCount += card.getQuantity();
        }

        if (mainDeckCount < 60) {
            throw new IllegalArgumentException("Main deck can't have less than 60 cards.");
        }

        int sideboardCount = 0;
        for (CardInDeckDTO card : sideboard) {
            Assert.hasText(card.getCard_name(), "Card names must be set.");
            if (card.getQuantity() < 1) {
                throw new IllegalArgumentException("Card quantity can't be less than 1.");
            } else if (card.getQuantity() > 4) {
                boolean isBasicLand = false;
                for (String basicLand : basicLands) {
                    if (basicLand.equals(card.getCard_name())) {
                        isBasicLand = true;
                    }
                }
                if (!isBasicLand) {
                    throw new IllegalArgumentException("Card quantity can't be more than 4 for all cards except basic lands.");
                }
            }
            sideboardCount += card.getQuantity();
        }

        if (sideboardCount > 15) {
            throw new IllegalArgumentException("Sideboard can't have more than 15 cards.");
        }

        Deck deck = deckCheck.get();

        deck.setDeck_name(deck_name);
        deck.setFormat(format);

        for (CardInDeck card : deck.getCards()) {
            cardInDeckRepo.delete(card);
        }

        for (CardInDeckDTO card : main_deck) {
            cardInDeckRepo.save(new CardInDeck(deck, card.getCard_name(), card.getQuantity(), true));
        }

        for (CardInDeckDTO card : sideboard) {
            cardInDeckRepo.save(new CardInDeck(deck, card.getCard_name(), card.getQuantity(), false));
        }

        Deck newDeck = deckRepo.findById(deck.getDeck_id()).get();

        return newDeck;
    }

    @Override
    public void deleteDeck(long id) {
        Optional<Deck> deckCheck = deckRepo.findById(id);
        if (!deckCheck.isEmpty()) {
            Deck deck = deckCheck.get();
            for (CardInDeck card : deck.getCards()) {
                cardInDeckRepo.delete(card);
            }
            deckRepo.delete(deck);
        }
    }
}
