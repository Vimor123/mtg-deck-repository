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

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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
            for (CardInDeck card : deck.getCards()) {
                if (card.isIn_main_deck()) {
                    main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
                } else {
                    sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
                }
            }
            deckOutDTOs.add(new DeckOutDTO(creator, deck_name, format, main_deck, sideboard));
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
        for (CardInDeck card : deck.getCards()) {
            if (card.isIn_main_deck()) {
                main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            } else {
                sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            }
        }
        return new DeckOutDTO(creator, deck_name, format, main_deck, sideboard);
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
        for (CardInDeck card : deck.getCards()) {
            if (card.isIn_main_deck()) {
                main_deck.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            } else {
                sideboard.add(new CardInDeckDTO(card.getCard_name(), card.getQuantity()));
            }
        }

        DeckOutDTO deckOutDTO = new DeckOutDTO(creator, deck_name, format, main_deck, sideboard);

        return new ResponseEntity<>(deckOutDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public DeckOutDTO edit(@RequestBody DeckInDTO deckInDTO, @RequestHeader(value = "Authorization", required = false) String auth, @PathVariable Long id) {
        return null;
    }
}
