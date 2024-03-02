package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApacheHttpClientDemo {

	public static void main(String[] args) {
		try {
			System.out.println(whenPostJsonUsingHttpClient_thenCorrect());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String whenPostJsonUsingHttpClient_thenCorrect() 
			throws ClientProtocolException, IOException {

		String urlPath = "https://oauth2.googleapis.com/token";
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(urlPath);

		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("client_id",
				"755132911695-pk6pf8gaos0ti3h1np0vlbccmqnpjnhl.apps.googleusercontent.com"));
		params.add(new BasicNameValuePair("client_secret", "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"));
		params.add(new BasicNameValuePair("grant_type", "refresh_token"));
		params.add(new BasicNameValuePair("refresh_token",
				"1//0g_8vnNEcl3cmCgYIARAAGBASNgF-L9Ir6za5uovvtfYCF7S9MIyRj8Kk_pEfQiSRmhmgBv3y5Yd2Kbq3GP2YI77E8NeAZfHXig"));
		httpPost.setEntity(new UrlEncodedFormEntity(params));

		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		CloseableHttpResponse response = client.execute(httpPost);

		HttpEntity entity1 = response.getEntity();
		String responseContent = EntityUtils.toString(entity1);
		client.close();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(responseContent);
		
		String newAccessToken = node.get("access_token").textValue();
		
		return newAccessToken;
	}

}
