package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;

public class GETRequestHTTPClient {
	
	private static final String POST_URI = "https://accounts.google.com/o/oauth2/v2/auth?client_id=755132911695-pk6pf8gaos0ti3h1np0vlbccmqnpjnhl.apps.googleusercontent.com&redirect_uri=http://localhost:8080/Deep/home.htm&response_type=code&scope=https://www.googleapis.com/auth/gmail.modify&access_type=offline";

	public static void main(String[] args) throws IOException, InterruptedException {
		String clientId = "755132911695-pk6pf8gaos0ti3h1np0vlbccmqnpjnhl.apps.googleusercontent.com";

		String clientSecret = "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";

//		HttpClient httpClient = HttpClient.newBuilder().build();
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
								.GET()
								.header("accept", "application/json")
								.uri(URI.create(POST_URI))
								.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.body());
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.readTree(response.body());
		
		
		
	}
	
}
