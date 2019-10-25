package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Game {
	private String title;
	private String console;
	private int released;
	
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Game(String title, String console, int released) {
		super();
		this.title= title;
		this.console = console;
		this.released = released;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}

	public int getReleased() {
		return released;
	}

	public void setReleased(int released) {
		this.released = released;
	}

	@Override
	public String toString() {
		return "Game [title=" + title + ", console=" + console + ", year released=" + released + "]";
	}
	

}
