package br.com.axe.CRUDLivros.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.axe.CRUDLivros.entities.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByTitle(String title);

}
