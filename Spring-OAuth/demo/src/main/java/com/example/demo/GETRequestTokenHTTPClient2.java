package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.Flow.Subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;

public class GETRequestTokenHTTPClient2 {
	

//	https://oauth2.googleapis.com/token?client_id=&client_secret=&grant_type=&refresh_token=
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String clientId = "755132911695-pk6pf8gaos0ti3h1np0vlbccmqnpjnhl.apps.googleusercontent.com";

		String clientSecret = "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";
		
		String refreshToken = "";

		String POST_URI = "https://oauth2.googleapis.com/token?client_id="+clientId+"&client_secret="+clientSecret+"&grant_type=refresh_token&refresh_token="+refreshToken;

		HttpClient client = HttpClient.newHttpClient();
		
		String str = "https://oauth2.googleapis.com/token";
		
		String str2 = "client_id="+clientId+"&client_secret="+clientSecret+"&grant_type=refresh_token&refresh_token="+refreshToken;
		
		HttpRequest request = HttpRequest.newBuilder()
								.POST(HttpRequest.BodyPublishers.ofString(str2))
								.header("accept", "application/json")
								.uri(URI.create(str))
								.build();
		
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.body());
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.readTree(response.body());
		
		
		
	}
	
}
