package edu.odds.storage;

import edu.odds.model.Odds;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA interface to Odds database
 */
public interface OddsRepository extends JpaRepository<Odds, Long> {
}
