package edu.odds.validators;

import edu.odds.model.Odds;

import java.util.StringTokenizer;

/**
 * Odds validator responsible for checking all fields and format of odds value
 */
public class OddsValidator {

    /**
     * Validate odds object
     * @param odds odds object
     * @throws ValidationException on any not filled field or invalid format of odds value
     */
    public void validateOdds(Odds odds) throws ValidationException {
        if (odds == null) {
            throw new ValidationException("Odds object can not be empty");
        }
        validateNotEmpty(odds.getBetId(), "betId");
        validateNotEmpty(odds.getUserId(), "userId");
        validateOddsValue(odds.getOdds());
    }

    private void validateOddsValue(String odds) throws ValidationException {
        validateNotEmpty(odds, "odds");
        validateFormat(odds);
    }

    private void validateNotEmpty(Long betId, String propertyName) throws ValidationException {
        if (betId == null) {
            throw new ValidationException(String.format("%s value can not be empty", propertyName));
        }
    }

    private void validateNotEmpty(String oddsValue, String propertyName) throws ValidationException {
        if (oddsValue == null || "".equals(oddsValue.trim())) {
            throw new ValidationException(String.format("%s value can not be empty", propertyName));
        }
    }

    private void validateFormat(String oddsValue) throws ValidationException {
        StringTokenizer tokenizer = new StringTokenizer(oddsValue, "/");
        if (tokenizer.countTokens() == 1) {
            validateSP(oddsValue);
        } else {
            validateTokens(tokenizer);
        }
    }

    private void validateTokens(StringTokenizer tokenizer) throws ValidationException {
        validateTokensCount(tokenizer);
        validateIsPositiveNumber(tokenizer.nextToken());
        validateIsPositiveNumber(tokenizer.nextToken());
    }

    private void validateTokensCount(StringTokenizer tokenizer) throws ValidationException {
        if (tokenizer.countTokens() != 2) {
            throw new ValidationException("Only two whole number values, separator or SP can be the value of the odds. E.g. 1/10 or SP");
        }
    }

    private void validateSP(String oddsValue) throws ValidationException {
        if (!"SP".equals(oddsValue)) {
            throw new ValidationException(String.format("Only SP can be single odds value: %s", oddsValue));
        }
    }

    private void validateIsPositiveNumber(String numberValue) throws ValidationException {
        Integer value = validateIsNumber(numberValue);
        if (value.intValue() < 1) {
            throw new ValidationException(String.format("%s is not an positive number", numberValue));
        }
    }

    private Integer validateIsNumber(String numberValue) throws ValidationException {
        Integer value = null;
        try {
            value = Integer.parseInt(numberValue);
        } catch (NumberFormatException e) {
            throw new ValidationException(String.format("%s is not an whole number", numberValue));
        }
        return value;
    }
}
