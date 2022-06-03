import java.util.ArrayList;
import java.util.Iterator;

public class Session {
	private int Id;
	private int[] score = { 0, 0 };
	private int nbr_repititions = 0;
	private ArrayList<Client> players = new ArrayList<Client>();

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int[] getScore() {
		return score;
	}

	public void setScore(int[] score) {
		this.score = score;
	}

	public int getNbr_repititions() {
		return nbr_repititions;
	}

	public void setNbr_repititions(int nbr_repititions) {
		this.nbr_repititions = nbr_repititions;
	}

	public ArrayList<Client> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Client> players) {
		this.players = players;
	}

	public Session(int sessionID, int clientID, String name) {
		setId(sessionID);
		players.add(createClient(clientID, name));
	}

	private Client createClient(int clientID, String name) {
		if (isPlayerExist(name)) {
			return new Client(getId(), clientID, name+"_2");
		}
		return new Client(getId(), clientID, name);
	}

	protected void addClient(int clientID, String name) {
		players.add(createClient(clientID, name));
	}
	
	private void deleteClient(int clinetID) {
		Iterator<Client> plyersIterator = players.iterator();
		
		while (plyersIterator.hasNext()) {
			Client player = (Client) plyersIterator.next();
			if (player.getId() == clinetID) {
				plyersIterator.remove();
//				System.out.println(player.getName() +" deleted!");
			}
		}
		
		//this doesn't work you should use Iterator or it will generate an Exception
//		for (Client player : plyersIterator) 
//			if ( player.getId() == clinetID) 
//				plyersIterator.remove(player);
			
	}
	
	private boolean isPlayerExist(String name) {
		for (Client player : players) 
			if(player.getName().equals(name))
				return true;
		
		return false;
	}
	
	private boolean isPlayerExist(int clienID) {
		for (Client  client: players)
			if (client.getId() == clienID) 
				return true;
		return false;
	}
	
	protected boolean isFull() {
		if (players.size() == 2)
			return true;
		return false;
	}

	protected void showPlayers() {
		for (Client player : players)
			System.out.println(player.toString());
	}
}
