package cl.binter.challenge.usecase;

import cl.binter.challenge.domain.dao.RankingWords;
import cl.binter.challenge.domain.entities.Text;
import cl.binter.challenge.domain.repository.TextRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TextFinder {

    private TextRepository textRepository;

    @Autowired
    public void setTextRepository(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    public Text getText(Long id, Integer page) {
        if (Objects.isNull(page)) {
            if (Objects.isNull(id)) {
                return getRandomText();
            }
            return textRepository.findText(id);
        }
        return textRepository.findText(id, page);
    }

    public Text getRandomText() {
        List<Long> allIds = textRepository.findAllIds();
        Random rnd = new Random();
        Integer index = rnd.nextInt(allIds.size());
        return textRepository.findText(allIds.get(index));
    }

    public List<RankingWords> wordRanking(Long id, Integer page, Long size) {
        Text text = textRepository.findText(id, page);
        var result = mostCommonWords(text.getText());
        if (size != -1) {
            return result.stream().limit(size).collect(Collectors.toList());
        }
        return result;
    }

    private List<RankingWords> mostCommonWords(String paragraph) {
        if (Objects.nonNull(paragraph) && paragraph.length() > 0) {
            var result = new HashSet<RankingWords>();
            List<String> words = Arrays.stream(paragraph.replaceAll("[!?',;.]", "").toLowerCase()
                    .split(" "))
                    .collect(Collectors.toList());
            var uniqueWord = new HashSet<>(words);
            for (String word : uniqueWord) {
                result.add(new RankingWords(word, (int) words.stream().filter(word::equals).count()));
            }
            return result.stream().sorted(Comparator.comparing(RankingWords::getMatch).reversed()).collect(Collectors.toList());
        }
        log.info("[TextFinder] Nothing paragraph to process and return empty array");
        return new ArrayList<>();
    }

}
