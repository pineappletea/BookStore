package palvelinohjelmointi.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String placeHolderResponse() {

		return "index";
	}
	public void doSomething(){
		List<Book> books=repository.findByTitle("Pikku Prinssi");
		}
}

	
