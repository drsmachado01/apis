package br.com.axe.CRUDLivros.utils;

import br.com.axe.CRUDLivros.entities.Book;

public class BookUtils {
	public static Book updateBookInfo(Book theOld, Book theNew) {
		if(!theOld.getTitle().equals(theNew.getTitle())) {
			theOld.setTitle(theNew.getTitle());
		}
		
		if(!theOld.getCategory().equals(theNew.getCategory())) {
			theOld.setCategory(theNew.getCategory());
		}
		
		if(!theOld.getIsbn().equals(theNew.getIsbn())) {
			theOld.setIsbn(theNew.getIsbn());
		}
		
		if(!theOld.getLanguage().equals(theNew.getLanguage())) {
			theOld.setLanguage(theNew.getLanguage());
		}
		
		if(!theOld.getReleaseYear().equals(theNew.getReleaseYear())) {
			theOld.setReleaseYear(theNew.getReleaseYear());
		}
		
		if(!theOld.getSynopsis().equals(theNew.getSynopsis())) {
			theOld.setSynopsis(theNew.getSynopsis());
		}
		
		if(!theOld.getTotalPages().equals(theNew.getTotalPages())) {
			theOld.setTotalPages(theNew.getTotalPages());
		}
		
		if(!theOld.getWriters().equals(theNew.getWriters())) {
			theOld.setWriters(theNew.getWriters());
		}
		
		return theOld;
	}
}
