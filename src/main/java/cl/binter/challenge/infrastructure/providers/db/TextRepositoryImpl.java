package cl.binter.challenge.infrastructure.providers.db;

import cl.binter.challenge.domain.entities.Text;
import cl.binter.challenge.domain.repository.TextRepository;
import cl.binter.challenge.infrastructure.providers.db.model.DbText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public class TextRepositoryImpl implements TextRepository {

    @Autowired
    private DbRepository repository;

    @Override
    public Text findText(Long id) {
        return findText(id, 1);
    }

	@Override
	public Text findText(Long id, Integer page) {
		Optional<DbText> modelText = repository.findById(id);
		Text response;
		if(modelText.isPresent()){
			response = Text.builder()
					.id(modelText.get().getId().toString())
					.totalPages(modelText.get().getTotalPages())
					.page(page)
					.title(modelText.get().getTitle())
					.paragraph(modelText.get().getPages().stream().filter(p -> p.getPageNumber().equals(page))
							.findFirst().orElseThrow(() ->new NotFoundException("Id no encontrado"))
							.getText())
					.build();
		}else{
			throw new NotFoundException("Id no encontrado");
		}

		return response;
	}

	@Override
    public List<Long> findAllIds() {
        return repository.getAllIds();
    }

}
