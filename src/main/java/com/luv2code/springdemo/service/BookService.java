package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.model.Book;

public interface BookService {

	public List<Book> getBooks();

	public void saveBook(Book theBook);

	public Book getBook(int theCode);

	public void deleteBook(int theCode);
}
