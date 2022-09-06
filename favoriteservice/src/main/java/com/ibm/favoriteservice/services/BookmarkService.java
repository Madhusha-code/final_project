package com.ibm.favoriteservice.services;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.favoriteservice.modal.Bookmark;
import com.ibm.favoriteservice.repository.BookmarkRepository;


@Service
public class BookmarkService {

	
	@Autowired
    private BookmarkRepository bookmarkRepository;
	
	
	 public Bookmark saveBookmark(Bookmark bookmark) {
		 
		return bookmarkRepository.save(bookmark);
	 }

	 public Optional<Bookmark> findById(String id) {
		 
			return bookmarkRepository.findById(id);
		 }

}
