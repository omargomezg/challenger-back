package cl.binter.challenge.usecase;

import cl.binter.challenge.domain.dao.RankingWords;
import cl.binter.challenge.domain.entities.Text;
import cl.binter.challenge.domain.repository.TextRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TextFinderTest {

    @InjectMocks
    private TextFinder textFinder;

    @Mock
    private TextRepository textRepository;

    @BeforeEach
    void setup() {
        // ReflectionTestUtils.setField(textFinder, );
    }

    @Test
    void wordRanking_success() {
        var text = Text.builder()
                .text("Hola mundo, el mundo esta a tus pies").build();
        when(textRepository.findText(1L, 3)).thenReturn(text);
        Set<RankingWords> result = textFinder.wordRanking(1L, 3);
        assertNotEquals(0, result.size());
        assertEquals(2, result.stream().filter(word -> word.getWord().equals("mundo")).findFirst().get().getMatch());
    }
}
