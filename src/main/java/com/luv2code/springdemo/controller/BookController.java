package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.model.Book;

import com.luv2code.springdemo.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	// need to inject our customer service
	@Autowired
	private BookService bookService;
	
	@GetMapping("/list")
	public String listBooks(Model theModel) {
		
		// get customers from the service
		List<Book> theBooks = bookService.getBooks();
				
		// add the customers to the model
		theModel.addAttribute("books", theBooks);
		
		return "list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "book-form";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		
		// save the customer using our service
		bookService.saveBook(theBook);	
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Book theBook = bookService.getBook(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("book", theBook);
		
		// send over to our form		
		return "book-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("bookId") int theId) {
		
		// delete the customer
		bookService.deleteBook(theId);
		
		return "redirect:/book/list";
	}
}










