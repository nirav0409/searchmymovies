package com.in28minutes.springboot.tutorial.basics.application.configuration.homePageManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class MovieSearchService {

	
	public String searchMovie(String movie) {
		String getUrl ="http://www.omdbapi.com/?apikey=f651b846&t="+movie;
		 URL url;
         String outputJson="";
		try {
			url = new URL(getUrl);
			HttpURLConnection xhr = (HttpURLConnection) url
	                  .openConnection();
            xhr.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(xhr.getInputStream()));
            String output="";
            while ((output = br.readLine()) != null) {
                //some code
            	outputJson +=output;
            }
            
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println("output"+ outputJson);

		return outputJson;
	}
}
