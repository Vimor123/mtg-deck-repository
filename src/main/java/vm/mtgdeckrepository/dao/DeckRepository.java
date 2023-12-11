package vm.mtgdeckrepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vm.mtgdeckrepository.domain.Deck;

public interface DeckRepository extends JpaRepository<Deck, Long> {
}
