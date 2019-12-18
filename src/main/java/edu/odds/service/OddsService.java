package edu.odds.service;

import edu.odds.model.Bet;
import edu.odds.model.Odds;
import edu.odds.validators.ValidationException;

/**
 * Odds service finding and saving validated odds
 */
public interface OddsService {
    /**
     * Return Bet array filled with found odds by bet Id
     * @param betId betId
     * @return array of odds
     */
    Bet fillByBetId(Long betId);

    /**
     * Validate and save an odds
     * @param odds odds
     * @throws ValidationException if fields are not filled or odds value contains invalid symbols
     */
    void saveOdd(Odds odds) throws ValidationException;
}
