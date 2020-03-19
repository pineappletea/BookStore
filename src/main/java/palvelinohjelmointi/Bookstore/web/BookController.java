package palvelinohjelmointi.Bookstore.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;
import palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	
	 // private Long IDcontainer;

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catrepository;
	
	@RequestMapping(value= "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = {"/index", "/booklist"}, method = RequestMethod.GET)
	public String displayBookList(Model model) {
		// List<Book> books = new ArrayList<Book>();
		// books.addAll((Collection<? extends Book>) repository.findAll());
		// System.out.println(books);
		model.addAttribute("books", repository.findAll());
		return "listbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catrepository.findAll());
		return "addbook";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:/index";
	}
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:../index";
	}
	// haetaan editoitava kirja esille, GET
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String showEditBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		model.addAttribute("categories", catrepository.findAll());
		// IDcontainer = id;
		return "editbook";
	}
	// lähetetään muokattu kirja tietokantaan
	@RequestMapping(value = "save/", method = RequestMethod.POST)
	public String editBook(Book book) {
		// book.setId(IDcontainer);
		repository.save(book);
		System.out.println((book.getId()));
		return "redirect:../index";
	}
	
	// REST get all books
	// all, not just one
	@RequestMapping(value="/books", method  = RequestMethod.GET) 
	public @ResponseBody List<Book> listBooksRest(@RequestBody Book book){
		return (List<Book>) repository.findAll();
	}
	// REST for one book by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> getBookById(@PathVariable("id") Long bookId) {	
    	return repository.findById(bookId);
    }   
}

	
