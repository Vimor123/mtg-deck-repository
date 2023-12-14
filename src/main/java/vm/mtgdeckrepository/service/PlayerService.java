package vm.mtgdeckrepository.service;

import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.domain.Player;

import java.util.List;

public interface PlayerService {
    Player createPlayer(String username, String password, boolean administrator);
    List<Player> getAll();
    Player getById(long id);
    Player getByUsername(String username);
    Player updatePlayer(long id, String username, String password, boolean administrator);
    void deletePlayer(long id);
    Player login(String username, String password);
    List<Deck> decksByPlayer(long id);
}
