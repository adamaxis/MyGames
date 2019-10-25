package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String player;
	private String status;
	
	@Autowired
	private Game game;
	
	public Status() {
		super();
		this.status = "unbeaten";
		// TODO Auto-generated constructor stub
	}
	public Status(String player) {
		super();
		this.player = player;
	}
	public Status(String name, String status) {
		super();
		this.player = name;
		this.status = status;
	}
	public String getPlayer() {
		return player;
	}
	public void setPlayer(String player) {
		this.player = player;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	@Override
	public String toString() {
		return "Status [player=" + player + ", status=" + status +
				", game=" + game + "]";
	}

}
