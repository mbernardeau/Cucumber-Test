package com.insa;

import java.util.Date;

public class Book {
	private final String title;
	private final String author;
	private final Date published;
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public Date getPublished() {
		return published;
	}
	
	public Book(String title, String author, Date published) {
		super();
		this.title = title;
		this.author = author;
		this.published = published;
	}
}
