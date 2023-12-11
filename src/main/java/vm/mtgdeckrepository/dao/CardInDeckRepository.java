package vm.mtgdeckrepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vm.mtgdeckrepository.domain.CardInDeck;

public interface CardInDeckRepository extends JpaRepository<CardInDeck, Long> {
}
