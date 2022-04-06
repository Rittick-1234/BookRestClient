package com.luv2code.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.luv2code.springdemo.model.Book;


@Service
public class BookServiceRestClientImpl implements BookService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public BookServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	

	@Override
	public List<Book> getBooks() {
		logger.info("in getBooks(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Book>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Book>>() {});

		// get the list of customers from response
		List<Book> books = responseEntity.getBody();

		logger.info("in getBooks(): books" + books);
		
		return books;
	}

	@Override
	public void saveBook(Book theBook) {
	logger.info("in saveBook(): Calling REST API " + crmRestUrl);
		
		int bookCode = theBook.getBookCode();

		// make REST call
		if (bookCode == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theBook, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theBook);
		}

		logger.info("in saveBook(): success");	
		
	}

	@Override
	public Book getBook(int theCode) {
		logger.info("in getBook(): Calling REST API " + crmRestUrl);

		// make REST call
		Book theBook = 
				restTemplate.getForObject(crmRestUrl + "/" + theCode, 
						Book.class);

		logger.info("in saveBook(): theCode=" + theBook);
		
		return theBook;
	}

	@Override
	public void deleteBook(int theCode) {
		logger.info("in deleteBook(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theCode);

		logger.info("in deleteBook(): deleted book theCode=" + theCode);
		
	}

}
