package palvelinohjelmointi.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category() {}

	public Long getCategoryId() {
		return categoryid;
	}

	public void setCategoryId(Long id) {
		this.categoryid = id;
	}

	@Override
	public String toString() {
		return "Category [id=" + categoryid + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getbooks() {
		return books;
	}

	public void setbooks(List<Book> books) {
		this.books = books;
	}

	public Category(String name, List<Book> books) {
		super();
		this.name = name;
		this.books = books;
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	

}

    