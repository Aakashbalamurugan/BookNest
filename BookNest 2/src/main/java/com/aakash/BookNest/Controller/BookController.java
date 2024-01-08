package com.aakash.BookNest.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


import org.springframework.web.bind.annotation.ResponseBody;


import com.aakash.BookNest.DAO.BookDao;
import com.aakash.BookNest.Model.Book;
import com.aakash.BookNest.Validator.BookValidator;

@Controller
public class BookController {

	@Autowired
	BookDao bookDao;

	@Autowired
	BookValidator bookValidator;

	@GetMapping("/")
	@ResponseBody
	public List<Book> showAllBook() {
	
		List<Book> books = bookDao.findAll();
		System.out.println(books);


		return bookDao.findAll();

	}

	@PostMapping("addBook")
	@ResponseBody
	public String addBook(Book book) {
		List<String> validate = bookValidator.validate(book);
		if(validate.isEmpty() && !bookDao.existsById(Integer.valueOf(book.getId()))) {
		bookDao.save(book);
		return "{Status: success, error: null }";
		
		}else {
			if(!bookDao.existsById(Integer.valueOf(book.getId()))){
				return "{Status: error, error: Book already exists }";
			}
			
			return "{Status: error, error: "+String.join(" ", validate)+ " }";
		}

	} 

	@GetMapping("book/{id}")
	@ResponseBody
	public Book showBook(@PathVariable("id") int id) {
	
		Book book = bookDao.getReferenceById(id);
		System.out.println(book);
		
		return book;
	}

	@PutMapping("updateBook")
	@ResponseBody
	public String UpdateBook(Book book) {

		if (book.getId() == 0) {
			return "{Status: error, error: Id is requried }";
		}
		
		List<String> validate = bookValidator.validate(book);

		if (bookDao.existsById(Integer.valueOf(book.getId())) && validate.isEmpty()) {
			
			bookDao.deleteById(Integer.valueOf(book.getId()));
			bookDao.save(book);
			

			return "{Status: success, error: null }";
		} else {
			return "{Status: error, error: "+String.join(" ", validate)+ " }";
		}
	}

	@DeleteMapping("deleteBook")
	@ResponseBody
	public String DeleteBook(Book book) {

		if (book.getId() == 0) {
			return "{Status: error, error: Id is requried }";
		}

		if (bookDao.existsById(Integer.valueOf(book.getId()))) {
			bookDao.deleteById(Integer.valueOf(book.getId()));

			return "{Status: success, error: null }";
		} else {
			return "{Status: error, error: id doesnt exisits }";
		}
	}

}
