package com.in28minutes.springboot.tutorial.basics.application.configuration.homePageManager;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class homePageController {

	@Autowired
	MovieSearchService movieSearchService;
	public static int count = 0;

	@RequestMapping("/home")
	public String createUserPage() {
		return "home";
	}

	@RequestMapping("/")
	public String rootPage() {
		return "home";
	}

	

	

	@RequestMapping(value = "/searchMovie", method = RequestMethod.POST)
	public void searchMovie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		String movie = httpServletRequest.getParameter("Movie");
		// String movie = httpServletRequest.getHeader("Movie");
		System.out.println("i am searching for " + movie);
		movie = movie.replaceAll("\\s", "%20");
		String response = movieSearchService.searchMovie(movie);
		try {
			httpServletResponse.getWriter().print(createjsonResponse(response));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String createjsonResponse(String response) {
		JsonParser springParser = JsonParserFactory.getJsonParser();
		Map<String, Object> map = springParser.parseMap(response);
		JSONObject responseJson = new JSONObject();
		responseJson.put("Poster", map.get("Poster"));
		responseJson.put("Title", map.get("Title"));
		responseJson.put("Plot", map.get("Plot"));
	    responseJson.put("count", ++count + "");
		responseJson.put("Genre", map.get("Genre"));
		responseJson.put("Genre", map.get("Genre"));
		responseJson.put("imdbRating", map.get("imdbRating"));

		System.out.println("response Json "+ responseJson.toString());

		return responseJson.toString();
		// TODO Auto-generated method stub
	}
}
