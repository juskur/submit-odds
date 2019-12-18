package edu.odds.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.odds.model.Bet;
import edu.odds.model.Odds;
import edu.odds.service.OddsService;
import edu.odds.validators.ValidationException;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-18T10:06:35.423+02:00")

@Controller
public class OddsApiController implements OddsApi {

    private static final Logger log = LoggerFactory.getLogger(OddsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final OddsService service;

    @org.springframework.beans.factory.annotation.Autowired
    public OddsApiController(ObjectMapper objectMapper, HttpServletRequest request, OddsService service) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.service = service;
    }

    /**
     * Find all Odds with provided betId
     * @param betId betId
     * @return Response with found odds or empty body with corresponding error code
     */
    public ResponseEntity<Bet> oddsBetIdGet(@ApiParam(value = "ID of bet to return", required = true) @PathVariable("betId") Long betId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Bet bet = service.fillByBetId(betId);
            if (bet.size() > 0) {
                return new ResponseEntity<Bet>(bet, HttpStatus.OK);
            } else {
                return new ResponseEntity<Bet>(HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<Bet>(HttpStatus.NOT_IMPLEMENTED);
    }

    /**
     * Save Odds to database
     * @param body odds
     * @return Empty body with corresponding success or error code
     */
    public ResponseEntity<Void> oddsPost(@ApiParam(value = "Odds that should be offered for a bet", required = true) @Valid @RequestBody Odds body) {
        try {
            service.saveOdd(body);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (ValidationException e) {
            log.debug(String.format("Odds no accepted: %s", e.getMessage()));
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
    }

}
