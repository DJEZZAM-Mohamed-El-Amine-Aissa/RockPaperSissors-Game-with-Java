import java.util.ArrayList;

import javax.print.attribute.Size2DSyntax;

public class Game {
	ArrayList<Session> sessions = new ArrayList<>();

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public Session getSessionsByID(int sessionID) {
		for (Session session : sessions) {
			if (session.getId() == sessionID)
				return session;
		}
		return null;
	}

	public static void main(String[] args) {
		Game rockPapaerSissorsGame = new Game();
		rockPapaerSissorsGame.showAllSession();

		rockPapaerSissorsGame.createSession(1, "moha");
		rockPapaerSissorsGame.showAllSession();
//		
		rockPapaerSissorsGame.createSession(2, "moha");
		rockPapaerSissorsGame.joinSession(2, "moha");
////		rockPapaerSissorsGame.
		rockPapaerSissorsGame.showAllSession();
//		
//		rockPapaerSissorsGame.joinSession(2, "moha");

//		session.deleteClient(1);
//		session.showPlayers();
//		
//		System.out.println(session.isNameExist("Player 1"));
//		
//		session.deleteClient(2);
//		session.showPlayers();
	}

	public Game() {
	}

	private void createSession(int sessionID, String name) {
		if (isSessionExist(sessionID))
			System.out.println("This session is already exist !");
		else
			sessions.add(new Session(sessionID, 1, name));
	}

	private boolean isSessionExist(int sessionID) {
		for (Session session : sessions)
			if (session.getId() == sessionID)
				return true;
		return false;
	}

	private boolean isSessionEmpty(int sessionID) {
		for (Session session : sessions)
			if (session.getId() == sessionID)
				if (session.getPlayers().size() == 20)
					return true;
		return false;

	}

	private void joinSession(int sessionID, String name) {
		if (isSessionExist(sessionID)) {
			Session session = getSessionsByID(sessionID);
			if (session.isFull())
				System.out.println(
						"this session(" + sessionID + ") is full! " + "\ntry after a while or join other session");
			else if (session.getPlayers().get(0).getId() == 2) { // If the first player leaves, the second player
																	// remains present
				session.addClient(1, name);
			} else
				session.addClient(2, name);

		} else {
			System.out.println("This session doesn't exist! \ntry another ID pls");
		}
	}

	private void leaveSession() {
		// TODO Auto-generated method stub

	}

	private void showAllSession() {
		System.out.println("acctual sessions: " + sessions.size());
		if (sessions.size() > 0) {
			System.out.println("########### Show all Sessions #############");
			for (Session session : sessions) {
				System.out.println("Session ID: " + session.getId());
				System.out.println("Session Score: " + session.getScore()[0] + " - " + session.getScore()[1]);
				int nbrPlayers = session.getPlayers().size();
				if (nbrPlayers == 1) {
					System.out.println("There's " + nbrPlayers + " player in this session");
				} else {
					System.out.println("There's " + nbrPlayers + " players in this session");
				}

				session.showPlayers();
				System.out.println("##########################################\n");
			}
		} else {
			System.out.println("There's no session ! \n");
		}
	}
}
