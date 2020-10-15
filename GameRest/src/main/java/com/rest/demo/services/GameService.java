package com.rest.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.stereotype.Service;
import com.rest.demo.exception.GameNoExistsException;
import com.rest.demo.model.GameDto;
import com.rest.demo.model.Genre;

@Service
public class GameService implements IGameService {

	private HashMap<String, GameDto> games = new HashMap<String, GameDto>();

	public GameService() {
		ArrayList<Genre> g = new ArrayList<Genre>();
		g.add(Genre.PUZLE);
		ArrayList<Genre> g2 = new ArrayList<Genre>();
		g2.add(Genre.TPS);
		g2.add(Genre.MULTIJUGADOR);

		games.put("RDR2", new GameDto("RDR2", "blabla", 1967, "Rockstar Games", g));
		games.put("GTA5", new GameDto("GTA5", "dsadsadsa", 2013, "Rockstar Games", g2));
		games.put("7 days to die", new GameDto("7 days to die", "The Fun Pimps", 2000, "urur"));
		games.put("Forza Horizon 4", new GameDto("Forza Horizon 4", "Turn 10 studios", 2000, "ahha"));

	}

	public boolean add(GameDto game) {
		games.put(game.getName(), game);
		return true;
	}

	public boolean delete(String name) {

		games.remove(name);

		return true;
	}

	public GameDto getbyname(String name) {
		if (games.containsKey(name))
			return games.get(name);
		else
			throw new GameNoExistsException("Juego No encontrado");
	}

	public HashMap<String, GameDto> getGames() {
		return games;
	}

	public void setGames(HashMap<String, GameDto> games) {
		this.games = games;
	}

}
