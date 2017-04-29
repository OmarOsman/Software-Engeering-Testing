package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.forms.CreateGameForm;
import com.forms.GameSession;
import com.models.Course;
import com.models.Game;
import com.models.IUser;
import com.models.Question;
import com.services.CourseService;
import com.services.GameService;
import com.services.LoginService;
import com.services.ProgressService;
import com.services.QuestionService;
import com.services.UserService;

@Controller
@SessionAttributes({ "game", "score" })
public class GameController {

	@Autowired
	private GameService gameService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProgressService progressService;

	@RequestMapping(value = "/game/findGame", params = "gamename")
	public String PlayGame(Model model, @RequestParam("gamename") String gamename) {
		Game game = gameService.findByName(gamename);
		GameSession score = new GameSession();
		model.addAttribute("game", game);
		model.addAttribute("score", score);
		return "redirect:/game/PlayGame";
	}

	@RequestMapping(value = "/game/PlayGame")
	public String PlayGame(Model model, @ModelAttribute Question question, @ModelAttribute Game game,
			@ModelAttribute GameSession score, HttpServletRequest request) {
		score.setCount(0);
		List<Question> questions = questionService.findAll(game.getGameName());
		int cnt = questions.size();

		if (cnt != game.getNumberOfQuestions()) {
			String radio = request.getParameter("radio");
			question = questions.get(game.getNumberOfQuestions());
			if (question.isRight(radio)) {
				score.count++;
			} else {
				System.out.println("Wrong Answer");
			}

		}

		if (game.getNumberOfQuestions() > 0) {
			question = questions.get(game.getNumberOfQuestions() - 1);
			game.setNumberOfQuestions(game.getNumberOfQuestions() - 1);
			model.addAttribute("question", question);
			return "game/PlayTF";
		} else {
			IUser currUser = userService.findByName(loginService.getCurrentUserID());
			if (!currUser.isTeacher()) {
				progressService.addProgress(score.getCount(), currUser.getUsername(), game.getGameName());
			}
			score.setCount(0);
			game.setNumberOfQuestions(questions.size());

			if (currUser.isTeacher())
				return "redirect:/teacher";
			else
				return "redirect:/student";
		}
	}

	@RequestMapping("/game/CreateGame")
	public String GameForm(Model model) {
		CreateGameForm gameform = new CreateGameForm();
		model.addAttribute("gameform", gameform);
		return "game/CreateGame";
	}

	@RequestMapping(value = "/game/CreateGame", method = RequestMethod.POST)
	public String GameForm(@Valid CreateGameForm gameform, BindingResult bindingResult, Model model) {

		Game g1 = new Game(gameform.getGamename(), gameform.getQuestions(), gameform.getGamecourse());
		g1.gameOwner = loginService.getCurrentUserID();
		gameService.add(g1);
		Question question = new Question();
		model.addAttribute("game", g1);
		model.addAttribute("question", question);
		return "game/CreateGameQuestions";
	}

	@RequestMapping(value = "/game/CreateGameQuestions", method = RequestMethod.POST)
	public String GameQuestions(@ModelAttribute Question question, @ModelAttribute Game g1) {
		if (g1.getNumberOfQuestions() > 0) {
			g1.setNumberOfQuestions(g1.getNumberOfQuestions() - 1);
			question.setGame(g1);
			questionService.add(question);
			if (g1.getNumberOfQuestions() == 0) {
				g1.setNumberOfQuestions(questionService.findAll(g1.getGameName()).size());
				Course course = courseService.findByName(g1.getGameCourse());
				g1.setCourse(course);
				gameService.add(g1);
				return "redirect:/teacher";
			}
			return "/game/CreateGameQuestions";
		}
		return "redirect:/teacher";

	}
}
