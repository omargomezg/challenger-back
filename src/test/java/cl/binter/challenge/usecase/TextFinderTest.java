package cl.binter.challenge.usecase;

import cl.binter.challenge.domain.dao.RankingWords;
import cl.binter.challenge.domain.entities.Text;
import cl.binter.challenge.domain.repository.TextRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
                .paragraph("Hola mundo, el mundo esta a tus pies").build();
        when(textRepository.findText(1L, 3)).thenReturn(text);
        List<RankingWords> result = textFinder.wordRanking(1L, 3, 4L);
        assertEquals(4, result.size());
        assertEquals(2, result.stream().filter(word -> word.getWord().equals("mundo")).findFirst().get().getMatch());
    }
}
