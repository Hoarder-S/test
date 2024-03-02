package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		// https://www.oauth.com/oauth2-servers/access-tokens/client-credentials/
		Map values = new HashMap<String, String>() {
			{
//		            put("client_id", URLEncoder.encode(Constants.oauthClientId, "UTF-8"));
//		            put ("client_secret", URLEncoder.encode(Constants.oauthSecret, "UTF-8"));
//		            put("grant_type", Constants.grantType);

				put("client_id",
						encodeIfRequired("998769525488-0shi18s6cv5aaj7jd5lq2p69opfduf4c.apps.googleusercontent.com"));
				put("client_secret", encodeIfRequired("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"));
				put("grant_type", "refresh_token");
				put("scope", "https://mail.google.com/");
				put("refresh_token", "1//04MW-rdJ1Hno-CgYIARAAGAQSNwF-L9IrP5-bjxpFBOlHo0yVCiXVMsy-4dTFkrMRYtvljHtZRCdJD6MEu0abfuXf2RMdtMQRzzw");
			}

			private String encodeIfRequired(String value) {

				boolean encode = true;

				if (encode) {
					return URLEncoder.encode(value);
				}
				return value;
			}
		};

		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(values);

		boolean ampSeperated = false;

		if (ampSeperated) {

			requestBody = ampSeperatedValues(values);

		}

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().setHeader("Content-Type", "application/x-www-form-urlencoded")
				// .setHeader("Content-Type", "application/json")
				.uri(URI.create("https://oauth2.googleapis.com/token"))
				.POST(HttpRequest.BodyPublishers.ofString(requestBody)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println(response.body());
	}

	private static String ampSeperatedValues(Map values) {
		StringBuilder sb = new StringBuilder();
		values.forEach((k, v) -> {

			sb.append(k).append("=").append(v).append("&");

		});
		String s = sb.toString();

		s = s.substring(0, s.length() - 1);

		return s;
	}

}
