package cl.binter.challenge.infrastructure.providers.db.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name="Text")
@Table(name="text")
@Data
public class DbText {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name="title", nullable = false)
	private String title;

	@Column(name="total_pages")
	private Integer totalPages;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "text_id")
	private List<Page> pages;

}
