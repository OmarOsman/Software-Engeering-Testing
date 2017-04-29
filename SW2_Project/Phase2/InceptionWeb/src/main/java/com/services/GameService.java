package com.services;
import java.util.*;
import com.models.*;

public interface GameService {

	   List<Game> findAll(String coursename);
	   Game findByName(String name);
	   void add (Game game);
	}

