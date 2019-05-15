/**
 * 
 */
package com.amrit.springboot.demo.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amrit.springboot.demo.beans.Book;

/**
 * @author amrit
 *
 */
@RestController
public class BookController {

	/**
	 * 
	 */
	public BookController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("books")
	public List books() {
		List<Book> booksList = new ArrayList<Book>();
		booksList.add(new Book(123, "Mastering Spring 5.0", "Amrit Pandey"));
		return booksList;
	}
}
