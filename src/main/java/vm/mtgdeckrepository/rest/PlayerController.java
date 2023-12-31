package vm.mtgdeckrepository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vm.mtgdeckrepository.domain.CardInDeck;
import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.domain.Player;
import vm.mtgdeckrepository.dto.CardInDeckDTO;
import vm.mtgdeckrepository.dto.DeckOutDTO;
import vm.mtgdeckrepository.dto.PlayerInDTO;
import vm.mtgdeckrepository.dto.PlayerOutDTO;
import vm.mtgdeckrepository.error.RequestDeniedException;
import vm.mtgdeckrepository.error.UnauthorizedAccessException;
import vm.mtgdeckrepository.service.PlayerService;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public List<PlayerOutDTO> getAll() {
        List<Player> players = playerService.getAll();
        List<PlayerOutDTO> playerOutDTOs = new ArrayList<>();
        for (Player player : players) {
            playerOutDTOs.add(new PlayerOutDTO(player.getPlayer_id(), player.getUsername(), player.isAdministrator()));
        }
        return playerOutDTOs;
    }

    @GetMapping("/{id}")
    public PlayerOutDTO getById(@PathVariable Long id) {
        Player player = playerService.getById(id);
        return new PlayerOutDTO(player.getPlayer_id(), player.getUsername(), player.isAdministrator());
    }

    @PostMapping("")
    public ResponseEntity<PlayerOutDTO> create(@RequestBody PlayerInDTO playerInDTO, @RequestHeader(value = "Authorization", required = false) String auth) {
        if (auth == null) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        byte[] decodedBytes = Base64.getDecoder().decode(auth.substring(6));
        String decodedString = new String(decodedBytes);
        String username = decodedString.substring(0, decodedString.indexOf(":"));
        String password = decodedString.substring(decodedString.indexOf(":") + 1);

        Player admin = playerService.login(username, password);
        if (!admin.isAdministrator()) {
            throw new RequestDeniedException("Administrator only operation.");
        }

        Player newPlayer = playerService.createPlayer(playerInDTO.getUsername(), playerInDTO.getPassword(), playerInDTO.isAdministrator());

        return new ResponseEntity<PlayerOutDTO>(new PlayerOutDTO(newPlayer.getPlayer_id(), newPlayer.getUsername(), newPlayer.isAdministrator()), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public PlayerOutDTO edit(@RequestBody PlayerInDTO playerInDTO, @RequestHeader(value = "Authorization", required = false) String auth, @PathVariable Long id) {
        if (auth == null) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        byte[] decodedBytes = Base64.getDecoder().decode(auth.substring(6));
        String decodedString = new String(decodedBytes);
        String username = decodedString.substring(0, decodedString.indexOf(":"));
        String password = decodedString.substring(decodedString.indexOf(":") + 1);

        Player authPlayer = playerService.login(username, password);

        Player targetPlayer = playerService.getById(id);

        if (!authPlayer.isAdministrator() && !authPlayer.getUsername().equals(targetPlayer.getUsername())) {
            throw new RequestDeniedException("Administrator only operation.");
        }

        if (!authPlayer.isAdministrator() && playerInDTO.isAdministrator()) {
            throw new RequestDeniedException("Administrator only operation.");
        }

        String newUsername = targetPlayer.getUsername();
        String newPassword = targetPlayer.getPassword();
        boolean newAdministrator = targetPlayer.isAdministrator();

        if (playerInDTO.getUsername() != null) {
            newUsername = playerInDTO.getUsername();
        }
        if (playerInDTO.getPassword() != null) {
            newPassword = playerInDTO.getPassword();
        }
        newAdministrator = playerInDTO.isAdministrator();

        Player newPlayer = playerService.updatePlayer(id, newUsername, newPassword, newAdministrator);

        return new PlayerOutDTO(newPlayer.getPlayer_id(), newPlayer.getUsername(), newPlayer.isAdministrator());
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

        Player admin = playerService.login(username, password);
        if (!admin.isAdministrator()) {
            throw new RequestDeniedException("Administrator only operation.");
        }

        playerService.deletePlayer(id);
    }

    @GetMapping("/{id}/decks")
    public List<DeckOutDTO> getDecksByPlayer(@PathVariable Long id) {
        List<Deck> decks = playerService.decksByPlayer(id);

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
}
