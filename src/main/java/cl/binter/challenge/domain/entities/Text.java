package cl.binter.challenge.domain.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Text {
	private String id;
    private String title;
    private Integer page;
    private Integer totalPages;
    private String paragraph;
}
