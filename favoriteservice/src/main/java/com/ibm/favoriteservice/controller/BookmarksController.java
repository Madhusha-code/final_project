package com.ibm.favoriteservice.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.favoriteservice.modal.Bookmark;
import com.ibm.favoriteservice.modal.Countries;
import com.ibm.favoriteservice.services.BookmarkService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/fav")
public class BookmarksController {
	
	@Autowired
	private BookmarkService bookmarkservice;

	@SuppressWarnings("rawtypes")
    @PostMapping("/savebookmark/{id}")
    public ResponseEntity<Bookmark> savebookmarks(@RequestBody Countries country,@PathVariable String id) {
		System.out.print(id);
		Optional<Bookmark> bookmarkData = bookmarkservice.findById(id);
		if(bookmarkData.isPresent()) {
			System.out.print(bookmarkData.get().getBookmarks());
			List<Countries> countries=new ArrayList();
			countries.addAll(bookmarkData.get().getBookmarks());
			countries.add(country);
			Bookmark bookmark=bookmarkData.get();
			bookmark.setBookmarks(countries);
		    return new ResponseEntity<>(bookmarkservice.saveBookmark(bookmark), HttpStatus.OK);
			
		}
		else {
		List<Countries> countries=new ArrayList();
		countries.add(country);
		Bookmark bookmark=new Bookmark();
		bookmark.setId(id);
		bookmark.setBookmarks(countries);
	
	    return new ResponseEntity<>(bookmarkservice.saveBookmark(bookmark), HttpStatus.OK);
		}
		
    
    }
	
	@SuppressWarnings("rawtypes")
    @PostMapping("/Isbookmarked/{id}")
    public Optional<Bookmark> Isbookmarked(@PathVariable String id) {
		System.out.print(id);
		Optional<Bookmark> bookmarkData = bookmarkservice.findById(id);
		return bookmarkData; 
    }
	
	@SuppressWarnings("rawtypes")
    @PostMapping("/deletebookmark/{id}")
    public ResponseEntity<Bookmark> deletebookmarks(@RequestBody Countries country,@PathVariable String id) {
		System.out.print(country.getCountryname());
		Optional<Bookmark> bookmarkData = bookmarkservice.findById(id);
		if(bookmarkData.isPresent()) {
		//	System.out.print(bookmarkData.get().getBookmarks());
			Object val=country.getCountryname();
			List<Countries> countries=new ArrayList<>();
			countries.addAll(bookmarkData.get().getBookmarks());
			countries.remove(val);
			Bookmark bookmark=bookmarkData.get();
		
			for(Countries c:countries) {
				System.out.println("remove="+c.getCountryname());
			}
			 for (Countries c : new ArrayList<>(countries)) {
			        if (c.getCountryname().equalsIgnoreCase(country.getCountryname())) {
			        	countries.remove(c);
			            
			        }
			    }
			bookmark.setBookmarks(countries);
		    return new ResponseEntity<>(bookmarkservice.saveBookmark(bookmark), HttpStatus.OK);
			
		}else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    
    }
	
}
