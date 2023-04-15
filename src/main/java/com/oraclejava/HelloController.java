package com.oraclejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/cgv")
public class HelloController {

	private static final int PAGE_SIZE = 10;

	@Autowired
	private MovieRepository movieRepository;

	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	public ModelAndView index(@RequestParam(required = false, value = "page") Integer pageNumber) {
		pageNumber = (pageNumber == null) ? 1 : pageNumber;

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("msg", "안녕하세요2");
		//영화 id 순으로 정렬

		Page<Movie> movies =
				movieRepository.findAll(PageRequest.of(pageNumber - 1, PAGE_SIZE, Sort.by("movieId")));

		int current = movies.getNumber() + 1;
		int begin = 1;
		int end = movies.getTotalPages();

		mav.addObject("movieList", movies);
		mav.addObject("beginIndex", begin);
		mav.addObject("endIndex", end);
		mav.addObject("currentIndex", current);

		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(Model model) {
		return "movieCreate";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Movie movie, Model model) {

		movieRepository.save(movie);

		return "redirect:/cgv/";
	}


	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Model model) {
		Movie movie = movieRepository.findById(id).get();
		model.addAttribute("movie", movie);
		return "movieUpdate";
	}

	// 수정
	@RequestMapping(params = "update", value = "/update/{movieId}", method = RequestMethod.POST)
	public String update(Movie movie, Model model) {
		// smovie: 찾은 영화(searched movie)
		Movie smovie = movieRepository.findById(movie.getMovieId()).get();
		smovie.setTitle(movie.getTitle());
		smovie.setPrice(movie.getPrice());
		smovie.setSynopsis(movie.getSynopsis());
		movieRepository.save(smovie);
		return "redirect:/cgv";
	}

	// 삭제
	@RequestMapping(params = "delete", value = "/update/{movieId}", method = RequestMethod.POST)
	public String delete(@PathVariable Integer movieId, Model model) {
		Movie smovie = movieRepository.findById(movieId).get();
		movieRepository.delete(smovie);
		return "redirect:/cgv";
	}


}








