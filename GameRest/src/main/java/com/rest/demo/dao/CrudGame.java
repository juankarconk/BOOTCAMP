package com.rest.demo.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.rest.demo.model.Game;

public interface CrudGame extends CrudRepository<Game, Long> {

	public List<Game> findByName(String name);

	public List<Game> findByYear(int year);

}
