package dmacc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import dmacc.beans.Status;
import dmacc.controller.BeanConfiguration;
import dmacc.beans.Game;
import dmacc.repository.ContactRepository;

@SpringBootApplication
public class SpringListStarterApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringListStarterApplication.class, args);
	}
	
	@Autowired
	ContactRepository repo;

	@Override
	public void run(String... args) throws Exception {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		Status entry1 = appContext.getBean("status", Status.class);
		entry1.setGame(new Game("Dark Souls 3", "PC", 2016));
		repo.save(entry1);
		
		
		Status entry2 = new Status("Daniel D.", "Unbeaten");
		Game genericGame = appContext.getBean("game", Game.class);
		entry2.setGame(genericGame);
		repo.save(entry2);
		
		Status entry3 = new Status("Daniel D.", "Beaten");
		Game game2 = new Game("Dungeon Crawl: Stone Soup", "PC", 1997);
		entry3.setGame(game2);
		repo.save(entry3);

		Status entry4 = new Status("Daniel Draper", "Beaten");
		Game game3 = new Game("Pillars Of Eternity", "PC/Xbox/Switch", 2015);
		entry4.setGame(game3);
		repo.save(entry4);
		
		
		List<Status> allGames = repo.findAll();
		for(Status stat: allGames) {
			System.out.println(stat.toString());
		}
		
		((AnnotationConfigApplicationContext) appContext).close();
	}
}
