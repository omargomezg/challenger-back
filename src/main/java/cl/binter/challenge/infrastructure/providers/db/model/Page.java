package cl.binter.challenge.infrastructure.providers.db.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "page")
@Data
public class Page {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name="page_number")
	private Integer pageNumber;

	@Lob
	private String text;
}
