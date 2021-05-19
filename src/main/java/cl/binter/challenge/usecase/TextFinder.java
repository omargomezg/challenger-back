package cl.binter.challenge.usecase;

import cl.binter.challenge.domain.entities.Text;
import cl.binter.challenge.domain.repository.TextRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@Slf4j
public class TextFinder {

	private TextRepository textRepository;

	public Text getText(Long id, Integer page) {
		if(Objects.isNull(page)){
			if(Objects.isNull(id)){
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


	@Autowired
	public void setTextRepository(TextRepository textRepository) {
		this.textRepository = textRepository;
	}
}
