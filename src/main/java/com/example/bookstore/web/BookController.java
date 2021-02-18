package com.example.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {

	@Autowired
	private BookRepository bRepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String mainPage() {
		return "index";
	}
	
	// Booklist page
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookList(Model model) {
		model.addAttribute("books", bRepository.findAll());
		return "booklist";
	}
	
	// Delete a book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	// Add a book
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	// Save a book
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(Book book) {
		bRepository.save(book);
		return "redirect:booklist";
	}
	
	// Edit a book
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("Book", bRepository.findById(bookId));
		return "editbook";
	}
	
	// Save edited book
	@RequestMapping(value = "/editsave/{id}", method = RequestMethod.POST)
	public String saveEdited(@PathVariable("id") Long bookId, Book book) {
		Book newBook = book;
		bRepository.deleteById(bookId);
		bRepository.save(newBook);
		return "redirect:../booklist";
	}
	
}
