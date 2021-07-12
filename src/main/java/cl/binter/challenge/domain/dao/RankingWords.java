package cl.binter.challenge.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RankingWords {
    private String word;

    /**
     * Number of times is repeated
     */
    private Integer match;
}
