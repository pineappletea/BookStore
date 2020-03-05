package palvelinohjelmointi.Bookstore.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import palvelinohjelmointi.Bookstore.domain.Book;
import palvelinohjelmointi.Bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String displayBookList(Model model) {
		// List<Book> books = new ArrayList<Book>();
		// books.addAll((Collection<? extends Book>) repository.findAll());
		// System.out.println(books);
		model.addAttribute("books", repository.findAll());
		return "index";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		repository.save(book);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:../index";
	}
	// haetaan editoitava kirja esille, GET
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String showEditBook(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", repository.findById(id));
		return "editbook";
	}
	// lähetetään muokattu kirja tietokantaan
	@RequestMapping(value = "editbook/save/{id}", method = RequestMethod.POST)
	public String editBook(@ModelAttribute Book book, @PathVariable("id") Long id) {
		repository.deleteById(id);
		book.setID(id);
		repository.save(book);
		System.out.println((book.getId()));
		return "redirect:../../index";
	}
}

	
