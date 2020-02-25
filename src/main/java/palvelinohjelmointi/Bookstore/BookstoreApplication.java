package palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return(args) -> {
			// String title, String author, int year, 
						// String isbn, double price)
			
			log.info("Create a couple of books");
			repository.save(new Book("Pikku Prinssi", "Antoine de Saint-Exupéry", 1997, "9789510069851", 12.90));
			repository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", 1997, "9789510098752", 29.90));
			
			log.info("fetch all books");
			for (Book student : repository.findAll()) {
				log.info(student.toString());
			}
			
	};
	}
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
