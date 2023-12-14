package vm.mtgdeckrepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vm.mtgdeckrepository.domain.Deck;
import vm.mtgdeckrepository.domain.Player;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findAllByCreator(Player player);
}
