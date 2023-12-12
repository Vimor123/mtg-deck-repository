package vm.mtgdeckrepository.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import vm.mtgdeckrepository.dao.PlayerRepository;
import vm.mtgdeckrepository.domain.Player;
import vm.mtgdeckrepository.error.EntityMissingException;
import vm.mtgdeckrepository.error.RequestDeniedException;
import vm.mtgdeckrepository.error.UnauthorizedAccessException;
import vm.mtgdeckrepository.service.PlayerService;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceJpa implements PlayerService {

    @Autowired
    private PlayerRepository playerRepo;

    @Override
    public Player createPlayer(String username, String password, boolean administrator) {
        Assert.hasText(username, "Username must be set.");
        Assert.hasText(password, "Password must be set.");
        Assert.notNull(administrator, "Administrator value must be set.");

        if (playerRepo.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists.");
        }

        Player player = new Player(username, password, administrator);

        playerRepo.save(player);

        return player;
    }

    @Override
    public List<Player> getAll() {
        return playerRepo.findAll();
    }

    @Override
    public Player getById(long id) {
        Optional<Player> player = playerRepo.findById(id);
        if (player.isEmpty()) {
            throw new EntityMissingException("Player not found.");
        }
        return player.get();
    }

    @Override
    public Player getByUsername(String username) {
        Optional<Player> player = playerRepo.findByUsername(username);
        if (player.isEmpty()) {
            throw new EntityMissingException("Player not found.");
        }
        return player.get();
    }

    @Override
    public Player updatePlayer(long id, String username, String password, boolean administrator) {
        Optional<Player> playerCheck = playerRepo.findById(id);
        if (playerCheck.isEmpty()) {
            throw new EntityMissingException("Player not found.");
        }

        if (playerRepo.existsByUsername(username)) {
            throw new IllegalArgumentException("Username already exists.");
        }

        Player player = playerCheck.get();
        player.setUsername(username);
        player.setPassword(password);
        player.setAdministrator(administrator);

        playerRepo.save(player);

        return player;
    }

    @Override
    public void deletePlayer(long id) {
        Optional<Player> player = playerRepo.findById(id);
        if (player.isEmpty()) {
            throw new EntityMissingException("Player not found.");
        }
        playerRepo.delete(player.get());
    }

    @Override
    public Player login(String username, String password) {
        Optional<Player> playerCheck = playerRepo.findByUsername(username);
        if (playerCheck.isEmpty()) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        Player player = playerCheck.get();
        if (!player.getPassword().equals(password)) {
            throw new UnauthorizedAccessException("Wrong username/password.");
        }
        return player;
    }
}
