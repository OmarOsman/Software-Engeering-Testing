package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.models.Game;
import com.repositories.GameRepository;

@Service
@Primary
public class GameServiceJpaImpl implements GameService {

	@Autowired
	private GameRepository GameRepository;

	@Override
	public List<Game> findAll(String coursename) {
		List<Game> games = new ArrayList<>();
		GameRepository.findByCourseCourseName(coursename).forEach(games::add);
		return games;
	}

	@Override
	public Game findByName(String name) {
		return this.GameRepository.findOne(name);
	}

	@Override
	public void add(Game game) {
		this.GameRepository.save(game);

	}

}
