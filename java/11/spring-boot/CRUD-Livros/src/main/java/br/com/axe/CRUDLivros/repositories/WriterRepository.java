package br.com.axe.CRUDLivros.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.axe.CRUDLivros.entities.Writer;

@Repository
public interface WriterRepository extends CrudRepository<Writer, Long> {

}
