package palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreRepositoryTests {
	 @Autowired
	    private BookRepository repository;

	    @Test
	    public void findByTitle() {
	        List<Book> books = repository.findByTitle("Pikku Prinssi");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getPrice()).isEqualTo(12.9);
	    }
	    
	    @Test
	    public void createNewBook() {
	    	// public Book(String title, String author, int year, String isbn, double price, Category category)
	    	Book book = new Book("Villiyrttikeittokirja", "Sami Tallberg", 2010, "978-952-220-234-5", 15.90, 
	    			new Category("Keittokirjat"));
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }   
	    
	    @Test
	    public void deleteBook() {
	    	repository.deleteById((long) 4); // delete
	    }


}
