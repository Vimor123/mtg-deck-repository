package vm.mtgdeckrepository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import vm.mtgdeckrepository.domain.Player;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByUsername(String username);
    Optional<Player> findByUsername(String username);
}
