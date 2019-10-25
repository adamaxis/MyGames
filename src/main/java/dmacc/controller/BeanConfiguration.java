package dmacc.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import dmacc.beans.Game;
import dmacc.beans.Status;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Status status() {
		// default player and game status - if it exists, I've likely beaten it
		Status bean = new Status("Daniel Draper", "Beaten");
		bean.setGame(game());
		return bean;
	}

	@Bean
	public Game game() {
		// generic game
		Game bean = new Game("[Game Name]", "[Game Console]", 1900);
		return bean;
	}


}
