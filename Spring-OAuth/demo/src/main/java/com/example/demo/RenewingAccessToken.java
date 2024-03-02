package com.example.demo;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RenewingAccessToken {
	public static void main(String[] args) throws IOException, InterruptedException, ParseException {

//		String urlPath = "https://oauth2.googleapis.com/token?client_id=755132911695-pk6pf8gaos0ti3h1np0vlbccmqnpjnhl.apps.googleusercontent.com&client_secret=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&grant_type=refresh_token&refresh_token=1//0g_8vnNEcl3cmCgYIARAAGBASNgF-L9Ir6za5uovvtfYCF7S9MIyRj8Kk_pEfQiSRmhmgBv3y5Yd2Kbq3GP2YI77E8NeAZfHXig";
//		HttpClient client = HttpClient.newHttpClient();
//		
//		HttpRequest request = HttpRequest.newBuilder()
//				.setHeader("Content-Type", "application/x-www-form-urlencoded")
//				.uri(URI.create(urlPath))
//				.POST(HttpRequest.BodyPublishers.noBody())
//				.build();
//		
//		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
		
//		String url = "https://gmail.googleapis.com/gmail/v1/users/me/profile";
//		
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpGet httpget = new HttpGet(url);
//		httpget.addHeader(HttpHeaders.AUTHORIZATION, "Bearer ya29.a0Aa4xrXPdeg1F7t1F5U_lhg9fKf23V-C2FZAdQjfLVukYamU9FLmGotBQsn6iNuIbnGi9Ck_avQ3DVm1LJvH9DjzhidQn1AebIBhh1uM_7qfZ8vKeKkRlEtJrRkiOvzJS21fPgnWxnL71NJUassr1I3A39a6zaQaCgYKATASARESFQEjDvL9ZJFERo4mQjzFwgIHhd9qkA0165");
//		CloseableHttpResponse httpresponse = httpclient.execute(httpget);
//		StatusLine statusLine = httpresponse.getStatusLine();
//		int statusCode = statusLine.getStatusCode();
//		System.out.println(statusCode);
		
		Calendar c = Calendar.getInstance();
		
		int yearOfTheDay = c.getWeekYear();
		
		String before50Years = "01/01/" + (yearOfTheDay - 50);
		
		Date newDate = (Date) new SimpleDateFormat("dd/mm/yyyy").parseObject(before50Years);
		
		String after50Years = "01/01/" + (yearOfTheDay + 50);
		
		Date newDate1 = (Date) new SimpleDateFormat("dd/mm/yyyy").parseObject(after50Years);
		
		System.out.println(newDate);
		
		boolean before = new Date().before(newDate);
		
		boolean after = new Date().after(newDate1);
		
		System.out.println(before);
		
		System.out.println(after);
		
	}
}
