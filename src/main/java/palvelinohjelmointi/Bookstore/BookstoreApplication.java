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
import palvelinohjelmointi.Bookstore.domain.User;
import palvelinohjelmointi.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository catRepository
			, UserRepository urepository){
		return(args) -> {
			// String title, String author, int year, 
						// String isbn, double price)
			
			log.info("Create categories");
			catRepository.save(new Category("Romaanit"));
			catRepository.save(new Category("Lasten ja nuorten kirjat"));
			
			log.info("Create a couple of books");
			bookRepository.save(new Book("Pikku Prinssi", "Antoine de Saint-Exupéry", 1997, "9789510069851", 12.90,
					catRepository.findByName("Lasten ja nuorten kirjat").get(0)));
			bookRepository.save(new Book("Sinuhe egyptiläinen", "Mika Waltari", 1997, "9789510098752", 29.90, 
					catRepository.findByName("Romaanit").get(0)));
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			// public Category(String name, List<Book> books)
			
			log.info("fetch all categories");
			for (Category category : catRepository.findAll()) {
				log.info(category.toString());
			}
			
// User(String username, String email, String password, String role)
			// Create users: admin/admin user/user
			User user1 = new User("user", "user@test", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "admin@test", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			log.info(user1.toString());
			urepository.save(user2);
			log.info(user2.toString());
	};
	}
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
