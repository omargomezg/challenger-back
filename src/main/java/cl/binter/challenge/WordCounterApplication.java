package cl.binter.challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordCounterApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WordCounterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
