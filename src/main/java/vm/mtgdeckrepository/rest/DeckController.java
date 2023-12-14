package vm.mtgdeckrepository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vm.mtgdeckrepository.domain.CardInDeck;
import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.domain.Player;
import vm.mtgdeckrepository.dto.*;
import vm.mtgdeckrepository.error.RequestDeniedException;
import vm.mtgdeckrepository.error.UnauthorizedAccessException;
import vm.mtgdeckrepository.service.DeckService;
import vm.mtgdeckrepository.service.PlayerService;

import java.util.*;

@RestController
@RequestMapping("/api/decks")
public class DeckController {
    @Autowired
    private DeckService deckService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public List<DeckOutDTO> getAll() {
        List<Deck> decks = deckService.getAll();
        List<DeckOutDTO> deckOutDTOs = new ArrayList<>();
        for (Deck deck : decks) {
            PlayerOutDTO creator = new PlayerOutDTO(deck.getCreator().getPlayer_id(), deck.getCreator().getUsername(), deck.getCreator().isAdministrator());
            String deck_name = deck.getDeck_name();
            String format = deck.getFormat();
            List<CardInDeckDTO> main_deck = new ArrayList<>();
            List<CardInDeckDTO> sideboard = new ArrayList<>();

            Set<CardInDeck> cards = deck.getCards();
            List<CardInDeck> cardList = new ArrayList<>();
            for (CardInDeck card : cards) {
                cardList.add(card);
            }

            Collections.sort(cardList,
                    (c1, c2) -> c1.getCard_name().compareTo(c2.getCard_name()));

            for (CardInDeck card : cardList) {
                if (card.isIn_main_deck()) {
                    main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
                } else {
                    sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
                }
            }
            deckOutDTOs.add(new DeckOutDTO(deck.getDeck_id(), creator, deck_name, format, main_deck, sideboard));
        }
        return deckOutDTOs;
    }

    @GetMapping("/{id}")
    public DeckOutDTO getById(@PathVariable Long id) {
        Deck deck = deckService.getById(id);
        PlayerOutDTO creator = new PlayerOutDTO(deck.getCreator().getPlayer_id(), deck.getCreator().getUsername(), deck.getCreator().isAdministrator());
        String deck_name = deck.getDeck_name();
        String format = deck.getFormat();
        List<CardInDeckDTO> main_deck = new ArrayList<>();
        List<CardInDeckDTO> sideboard = new ArrayList<>();

        Set<CardInDeck> cards = deck.getCards();
        List<CardInDeck> cardList = new ArrayList<>();
        for (CardInDeck card : cards) {
            cardList.add(card);
        }

        Collections.sort(cardList,
                (c1, c2) -> c1.getCard_name().compareTo(c2.getCard_name()));

        for (CardInDeck card : cardList) {
            if (card.isIn_main_deck()) {
                main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            } else {
                sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            }
        }
        return new DeckOutDTO(deck.getDeck_id(), creator, deck_name, format, main_deck, sideboard);
    }

    @PostMapping("")
    public ResponseEntity<DeckOutDTO> create(@RequestBody DeckInDTO deckInDTO, @RequestHeader(value = "Authorization", required = false) String auth) {
        if (auth == null) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        byte[] decodedBytes = Base64.getDecoder().decode(auth.substring(6));
        String decodedString = new String(decodedBytes);
        String username = decodedString.substring(0, decodedString.indexOf(":"));
        String password = decodedString.substring(decodedString.indexOf(":") + 1);

        Player player = playerService.login(username, password);

        Deck deck = deckService.createDeck(player, deckInDTO.getDeck_name(), deckInDTO.getFormat(), deckInDTO.getMain_deck(), deckInDTO.getSideboard());

        PlayerOutDTO creator = new PlayerOutDTO(deck.getCreator().getPlayer_id(), deck.getCreator().getUsername(), deck.getCreator().isAdministrator());
        String deck_name = deck.getDeck_name();
        String format = deck.getFormat();
        List<CardInDeckDTO> main_deck = new ArrayList<>();
        List<CardInDeckDTO> sideboard = new ArrayList<>();

        Set<CardInDeck> cards = deck.getCards();
        List<CardInDeck> cardList = new ArrayList<>();
        for (CardInDeck card : cards) {
            cardList.add(card);
        }

        Collections.sort(cardList,
                (c1, c2) -> c1.getCard_name().compareTo(c2.getCard_name()));

        for (CardInDeck card : cardList) {
            if (card.isIn_main_deck()) {
                main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            } else {
                sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            }
        }

        DeckOutDTO deckOutDTO = new DeckOutDTO(deck.getDeck_id(), creator, deck_name, format, main_deck, sideboard);

        return new ResponseEntity<>(deckOutDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public DeckOutDTO edit(@RequestBody DeckInDTO deckInDTO, @RequestHeader(value = "Authorization", required = false) String auth, @PathVariable Long id) {
        if (auth == null) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        byte[] decodedBytes = Base64.getDecoder().decode(auth.substring(6));
        String decodedString = new String(decodedBytes);
        String username = decodedString.substring(0, decodedString.indexOf(":"));
        String password = decodedString.substring(decodedString.indexOf(":") + 1);

        Player player = playerService.login(username, password);

        Deck deckToUpdate = deckService.getById(id);

        if (!player.getUsername().equals(deckToUpdate.getCreator().getUsername())) {
            throw new IllegalArgumentException("You can't change other player's decks.");
        }

        String deck_name = deckToUpdate.getDeck_name();
        if (deckInDTO.getDeck_name() != null) {
            deck_name = deckInDTO.getDeck_name();
        }

        String format = deckToUpdate.getFormat();
        if (deckInDTO.getFormat() != null) {
            format = deckInDTO.getFormat();
        }

        List<CardInDeckDTO> main_deck = new ArrayList<>();
        List<CardInDeckDTO> sideboard = new ArrayList<>();

        Set<CardInDeck> cards = deckToUpdate.getCards();
        List<CardInDeck> cardList = new ArrayList<>();
        for (CardInDeck card : cards) {
            cardList.add(card);
        }

        Collections.sort(cardList,
                (c1, c2) -> c1.getCard_name().compareTo(c2.getCard_name()));

        for (CardInDeck card : cardList) {
            if (card.isIn_main_deck()) {
                main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            } else {
                sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            }
        }

        if (deckInDTO.getMain_deck() != null) {
            main_deck = deckInDTO.getMain_deck();
        }
        if (deckInDTO.getSideboard() != null) {
            sideboard = deckInDTO.getSideboard();
        }


        Deck updatedDeck = deckService.updateDeck(id, deck_name, format, main_deck, sideboard);

        PlayerOutDTO creator = new PlayerOutDTO(player.getPlayer_id(), player.getUsername(), player.isAdministrator());
        String updatedDeck_name = updatedDeck.getDeck_name();
        String updatedFormat = updatedDeck.getFormat();
        List<CardInDeckDTO> updatedMain_deck = new ArrayList<>();
        List<CardInDeckDTO> updatedSideboard = new ArrayList<>();

        Set<CardInDeck> updatedCards = updatedDeck.getCards();
        List<CardInDeck> updatedCardList = new ArrayList<>();
        for (CardInDeck card : updatedCards) {
            updatedCardList.add(card);
        }

        Collections.sort(updatedCardList,
                (c1, c2) -> c1.getCard_name().compareTo(c2.getCard_name()));

        for (CardInDeck card : updatedCardList) {
            if (card.isIn_main_deck()) {
                updatedMain_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            } else {
                updatedSideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            }
        }

        DeckOutDTO deckOutDTO = new DeckOutDTO(updatedDeck.getDeck_id(),creator, updatedDeck_name, updatedFormat, updatedMain_deck, updatedSideboard);

        return deckOutDTO;
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestHeader(value = "Authorization", required = false) String auth, @PathVariable Long id) {
        if (auth == null) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        byte[] decodedBytes = Base64.getDecoder().decode(auth.substring(6));
        String decodedString = new String(decodedBytes);
        String username = decodedString.substring(0, decodedString.indexOf(":"));
        String password = decodedString.substring(decodedString.indexOf(":") + 1);

        Player player = playerService.login(username, password);

        deckService.deleteDeck(id, player.getUsername());
    }
}
