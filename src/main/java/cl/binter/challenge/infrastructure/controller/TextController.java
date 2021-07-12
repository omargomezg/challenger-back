package cl.binter.challenge.infrastructure.controller;

import cl.binter.challenge.domain.dao.RankingWords;
import cl.binter.challenge.domain.entities.Text;
import cl.binter.challenge.usecase.TextFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/word-counter")
public class TextController {

    private static final String GET_TEXT = "/text";
    private static final String MOST_COMMON_WORDS = "text/most-common";
    private TextFinder textFinder;

    @Operation(summary = "Get text")
    @ApiResponse(
            responseCode = "200",
            description = "Found a test",
            content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Text.class))
            }
    )
    @GetMapping(value = GET_TEXT, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getNearbyByCoordinates(@RequestParam(value = "id", required = false) Long id,
                                                         @RequestParam(value = "page", required = false) Integer page,
                                                         HttpServletRequest request) throws Exception {

        return ok(textFinder.getText(id, page));
    }

    @Operation(summary = "Get a list of words for some paragraph")
    @ApiResponse(
            responseCode = "200",
            description = "Words found",
            content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = RankingWords.class)))
            }
    )
    @GetMapping(value = MOST_COMMON_WORDS, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<RankingWords>> getMostCommonWordInParagraph(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "page") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "5") Long size) {
        return ok(textFinder.wordRanking(id, page, size));
    }

    @Autowired
    public void setTextFinder(TextFinder textFinder) {
        this.textFinder = textFinder;
    }
}
