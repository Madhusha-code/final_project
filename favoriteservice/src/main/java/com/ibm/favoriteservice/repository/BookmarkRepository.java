package com.ibm.favoriteservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.favoriteservice.modal.Bookmark;




public interface BookmarkRepository extends MongoRepository<Bookmark, String> {
	//User findByEmail(String email);
	
	
}