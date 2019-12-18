package edu.odds.service;

import edu.odds.model.Odds;
import edu.odds.storage.OddsRepository;
import edu.odds.validators.ValidationException;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.mockito.Mockito.mock;

@RunWith(JUnit4.class)
public class OddsServiceTest extends TestCase {

    OddsService service = null;

    @Before
    public void initialize() {
        OddsRepository repository = mock(OddsRepository.class);
        service = new OddsServiceImpl(repository);
    }

    private Odds prepareOdds() {
        Odds odds = new Odds();
        odds.setBetId(new Long(0L));
        odds.setUserId("user");
        odds.setOdds("1/9");
        return odds;
    }

    @Test
    public void testValidOdds1() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("1/10");
        service.saveOdd(odds);
    }

    @Test
    public void testValidOdds2() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("2/1");
        service.saveOdd(odds);
    }

    @Test
    public void testValidOdds3() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("SP");
        service.saveOdd(odds);
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOdds1() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("0/1");
        service.saveOdd(odds);
        fail("Invalid odd value does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOdds2() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("SP/1");
        service.saveOdd(odds);
        fail("Invalid odd value does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOdds3() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("2/3/4");
        service.saveOdd(odds);
        fail("Invalid odd value does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOdds4() throws Exception {
        Odds odds = prepareOdds();
        odds.setOdds("23*4");
        service.saveOdd(odds);
        fail("Invalid odd value does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOddsObjectNull() throws Exception {
        service.saveOdd(null);
        fail("Invalid odd value does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOddsObjectUserIdNull() throws Exception {
        Odds odds = prepareOdds();
        odds.setUserId(null);
        service.saveOdd(odds);
        fail("Invalid odds object does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOddsObjectUserIdEmpty() throws Exception {
        Odds odds = prepareOdds();
        odds.setUserId("");
        service.saveOdd(odds);
        fail("Invalid odds object does not raise any exceptions");
    }

    @Test(expected = ValidationException.class)
    public void testInvalidOddsObjectBetIdNull() throws Exception {
        Odds odds = prepareOdds();
        odds.setBetId(null);
        service.saveOdd(odds);
        fail("Invalid odds object does not raise any exceptions");
    }
}
