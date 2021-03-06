package com.rest.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rest.demo.converters.GameConverter;
import com.rest.demo.converters.GameDtoConverter;
import com.rest.demo.dao.CrudGame;
import com.rest.demo.dto.GameDto;
import com.rest.demo.exception.GameNoExistsException;
import com.rest.demo.model.Game;

@Service
public class GameServiceJpa {

	@Autowired
	CrudGame repository;
	@Autowired
	GameConverter gameConverter;
	@Autowired
	GameDtoConverter gameDtoConverter;

	public List<Game> findAll() {
		return (List<Game>) repository.findAll();
	}

	public boolean add(Game game) {

		repository.save(game);
		return true;
	}

	public boolean delete(Long id) {
		if (repository.existsById(id))
			throw new GameNoExistsException();
		repository.deleteById(id);
		return true;
	}

	public boolean update(GameDto newGame) {
		if (repository.existsById(newGame.getId()))
			throw new GameNoExistsException();
		Game game = repository.findById(newGame.getId()).get();
		game.setName(newGame.getName());
		game.setDescription(newGame.getDescription());
		game.setYear(newGame.getYear());

		repository.save(game);
		return true;
	}

	public GameDto getbyname(String name) {
		if (repository.findByName(name).isEmpty())
			throw new GameNoExistsException();
		return gameDtoConverter.getConverter(GameDto.class).convert(repository.findByName(name).get(0));
	}

	public GameDto getById(long id) {
		System.out.println(repository.findById(id).get());
		if (repository.findById(id).isEmpty())
			throw new GameNoExistsException();
		return gameDtoConverter.getConverter(GameDto.class).convert(repository.findById(id).get());
	}

}
