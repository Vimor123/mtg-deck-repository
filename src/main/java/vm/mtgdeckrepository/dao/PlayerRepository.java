package vm.mtgdeckrepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vm.mtgdeckrepository.domain.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
