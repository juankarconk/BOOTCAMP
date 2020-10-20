package com.rest.demo.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;
import com.rest.demo.dto.GameDto;
import com.rest.demo.model.Game;

@Component
public class GameConverter implements ConverterFactory<GameDto, Game> {

	@Override
	public <T extends Game> Converter<GameDto, T> getConverter(Class<T> targetType) {
		return new GameDtoToGame();
	}

	private final class GameDtoToGame<T extends Game> implements Converter<GameDto, Game> {

		@Override
		public Game convert(GameDto source) {

			return new Game(source.getId(), source.getName(), source.getDescription(), source.getYear());

		}

	}
}
