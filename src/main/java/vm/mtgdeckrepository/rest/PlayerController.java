package vm.mtgdeckrepository.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vm.mtgdeckrepository.domain.Player;
import vm.mtgdeckrepository.dto.PlayerInDTO;
import vm.mtgdeckrepository.error.RequestDeniedException;
import vm.mtgdeckrepository.error.UnauthorizedAccessException;
import vm.mtgdeckrepository.service.PlayerService;

import java.net.URI;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping("")
    public List<Player> getAll() {
        return playerService.getAll();
    }

    @GetMapping("/{id}")
    public Player getById(@PathVariable Long id) {
        return playerService.getById(id);
    }

    @PostMapping("")
    public ResponseEntity<Player> create(@RequestBody PlayerInDTO playerInDTO, @RequestHeader(value = "Authorization", required = false) String auth) {
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

        return new ResponseEntity<Player>(newPlayer, HttpStatus.CREATED);
    }
}
