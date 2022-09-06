package com.ibm.favoriteservice.modal;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookmarks")
public class Bookmark {
	@Id
    private String id;
    private List<Countries> bookmarks;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Countries> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(List<Countries> bookmarks) {
		this.bookmarks = bookmarks;
	}
    
    
    
}
