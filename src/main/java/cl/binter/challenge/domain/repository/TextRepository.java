package cl.binter.challenge.domain.repository;

import cl.binter.challenge.domain.entities.Text;

import java.util.List;

public interface TextRepository {
	Text findText(Long id);
	Text findText(Long id, Integer page);

	List<Long> findAllIds();
}
