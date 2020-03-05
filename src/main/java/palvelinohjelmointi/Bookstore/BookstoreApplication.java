package palvelinohjelmointi.Bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.Category;
import palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository catRepository){
		return(args) -> {
			// String title, String author, int year, 
						// String isbn, double price)
			
			log.info("Create a couple of books");
			bookRepository.save(new Book("Pikku Prinssi", "Antoine de Saint-Exupéry", 1997, "9789510069851", 12.90));
			bookRepository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", 1997, "9789510098752", 29.90));
			
			log.info("fetch all books");
			for (Book student : bookRepository.findAll()) {
				log.info(student.toString());
			}
			// public Category(String name, List<Book> books)
			
			log.info("Create categories");
			catRepository.save(new Category("Romaanit"));
			catRepository.save(new Category("Lasten ja nuorten kirjat"));
	};
	}
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
