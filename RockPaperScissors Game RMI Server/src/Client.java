
public class Client {
	private int Id = 0;
	private int sessionID = 0;
	private String name = "";
	private int choice = 0;
	private int score = 0;
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public Client() {}
	public Client(int sessionID, int clientID, String name) {
		setId(clientID);
		setSessionID(sessionID);
		setName(name);
	}
	
	public void win() {
		score++;
	}
	public void resetScore() {
		score = 0;
	}
	public void resetChoice() {
		choice = 0;
	}
	
	public String toString() {
		return "- Session ID: " + getSessionID() + ", Player ID: " + getId() + ", Name: " + getName();
	}
	
}
