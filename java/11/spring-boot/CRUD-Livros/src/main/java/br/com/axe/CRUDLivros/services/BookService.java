package br.com.axe.CRUDLivros.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.axe.CRUDLivros.entities.Book;
import br.com.axe.CRUDLivros.repositories.BookRepository;

@Component
public class BookService {
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book save(Book book) throws Exception {
		return this.bookRepository.save(book);
	}
	
	public Iterable<Book> list() throws Exception {
		return this.bookRepository.findAll();
	}
	
	public Book findByTitle(String title) throws Exception {
		return this.bookRepository.findByTitle(title);
	}
	
	public void delete(Long id) throws Exception {
		this.bookRepository.delete(this.bookRepository.findById(id).get());
	}

	public Book findById(Long id) {
		return this.bookRepository.findById(id).get();
	}
}
