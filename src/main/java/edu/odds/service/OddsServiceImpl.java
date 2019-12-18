package edu.odds.service;

import edu.odds.model.Bet;
import edu.odds.model.Odds;
import edu.odds.storage.OddsRepository;
import edu.odds.validators.OddsValidator;
import edu.odds.validators.ValidationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * Implementation of odds service
 */
@Service
public class OddsServiceImpl implements OddsService {

    private OddsRepository repository = null;
    private OddsValidator oddsValidator = new OddsValidator();

    public OddsServiceImpl(OddsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bet fillByBetId(Long betId) {
        Bet bet = new Bet();
        Odds exampleOdd = new Odds();
        exampleOdd.setBetId(betId);
        bet.addAll(repository.findAll(Example.of(exampleOdd, ExampleMatcher.matchingAll())));
        return bet;
    }

    @Override
    public void saveOdd(Odds odds) throws ValidationException {
        oddsValidator.validateOdds(odds);
        repository.save(odds);
    }
}
