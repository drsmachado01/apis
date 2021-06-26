package br.com.axe.CRUDLivros.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.axe.CRUDLivros.entities.Book;
import br.com.axe.CRUDLivros.services.BookService;
import br.com.axe.CRUDLivros.utils.BookUtils;

@RestController
@RequestMapping("/books")
public class BookController {
	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Book>> list() {
		List<Book> books = new ArrayList<Book>();
		try {
			this.bookService.list().iterator().forEachRemaining(books::add);
			return ResponseEntity.ok(books);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		try {
			this.bookService.save(book);
			return ResponseEntity.ok(book);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{title}")
	public ResponseEntity<Book> findById(@PathVariable("title") String title) {
		try {
			Book book = this.bookService.findByTitle(title);
			return ResponseEntity.ok(book);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> editBook(@PathVariable("id") Long id, @RequestBody Book book) {
		try {
			Book book_ = this.bookService.findById(id);
			this.bookService.save(BookUtils.updateBookInfo(book_, book));
			return ResponseEntity.ok(book_);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") Long id) {
		try {
			this.bookService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
