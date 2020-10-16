package com.rest.demo.services;

import com.rest.demo.dto.GameDto;

public interface IFGameService {

	public boolean add(GameDto game);

	public boolean delete(String name);

	public GameDto getbyname(String name);

}
