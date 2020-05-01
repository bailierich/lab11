package lab11;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private String catagory;
	private String title;

	public Movie(String title, String catagory) {
		this.catagory = catagory;
		this.title = title;
	}

	
	public Movie() {

	}
	
	public void setCatagory(String newCatagory) {
		catagory = newCatagory;
	}
	
	public void setTitle(String newTitle) {
		title = newTitle;
	}
	
	public String getCatagory() {
		return catagory;
	}
	
	public String getTitle() {
		return title;
	}
}
