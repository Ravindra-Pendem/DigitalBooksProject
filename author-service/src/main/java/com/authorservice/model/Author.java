package com.authorservice.model;

import java.util.Arrays;

public class Author {

	private int id;
	private String title;
	private String author;
	private String price;
	private String category;
	private String publisher;
	private String publishDate;
	private byte[] picByte;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public byte[] getPicByte() {
		return picByte;
	}
	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + ", category="
				+ category + ", publisher=" + publisher + ", publishDate=" + publishDate + ", picByte="
				+ Arrays.toString(picByte) + "]";
	}
	
}

