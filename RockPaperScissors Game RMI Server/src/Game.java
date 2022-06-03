import java.util.ArrayList;
import java.util.Iterator;


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

		// create a session 1 with a single player or client
		rockPapaerSissorsGame.createSession(1, "moha");
		rockPapaerSissorsGame.showAllSession();
		
		// create a session 2 with a single player or client 
		rockPapaerSissorsGame.createSession(2, "moha");
		rockPapaerSissorsGame.showAllSession();

		// player or client  join session 2 
		rockPapaerSissorsGame.joinSession(2, "moha");
		rockPapaerSissorsGame.showAllSession();

		// player or client 2 leave session 2
		rockPapaerSissorsGame.leaveSession(2, 1);
		rockPapaerSissorsGame.showAllSession();

		// player or client  join session 2
		rockPapaerSissorsGame.joinSession(2, "moha");
		rockPapaerSissorsGame.showAllSession();

		// player or client 2 leave session 2
		rockPapaerSissorsGame.leaveSession(2, 2);
		rockPapaerSissorsGame.showAllSession();

		// player or client  join session 2
		rockPapaerSissorsGame.joinSession(2, "moha");
		rockPapaerSissorsGame.showAllSession();
		
		// create a session with a single player or client in session1
		rockPapaerSissorsGame.leaveSession(1, 1);
		rockPapaerSissorsGame.showAllSession();
		
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

	private void deleteSession(int sessionID) {
		Iterator<Session> sessionsIterator = sessions.iterator();

		while (sessionsIterator.hasNext()) {
			Session session = (Session) sessionsIterator.next();
			if (session.getId() == sessionID) {
				sessionsIterator.remove();
//				System.out.println(player.getName() +" deleted!");
			}
		}

	}

//	private boolean isSessionEmpty(int sessionID) {
//		for (Session session : sessions)
//			if (session.getId() == sessionID)
//				if (session.getPlayers().size() == 0)
//					return true;
//		return false;
//
//	}

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

	private void leaveSession(int sessionID, int clientID) {
		Session session = getSessionsByID(sessionID);
		if (session.isFull()) // there is 2 players
			session.deleteClient(clientID);
		else // there is 1 player
			deleteSession(sessionID);
	}

	private void showAllSession() {
		System.out.println("acctual sessions: " + sessions.size());
		if (sessions.size() > 0) {
			System.out.println("-------------- Show all Sessions --------------");
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
				System.out.println("---------------------------------------------------\n");

			}
			System.out.println("##########################################\n");
		} else {
			System.out.println("There's no session ! \n");
		}
	}
}
