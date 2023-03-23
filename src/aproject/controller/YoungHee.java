package aproject.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import aproject.vo.EmpVO;

//용
public class YoungHee {

	public static void main(String[] args) throws IOException, InterruptedException {
		dataGet();

	}

	private static void dataGet() throws IOException, InterruptedException {
		List<EmpVO> emplist = new ArrayList<>();
		HttpRequest request = HttpRequest.newBuilder()
			    .uri(URI.create("https://api.bithumb.com/public/ticker/ALL_KRW"))
			    .header("accept", "application/json")
			    .method("GET", HttpRequest.BodyPublishers.noBody())
			    .build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
			String json = response.body();
			JSONObject root = new JSONObject(json);
			JSONObject jsonData = root.getJSONObject("data");
			System.out.println(jsonData);
			//Set<String> keys = jsonData.keySet();
			for(String key:jsonData.keySet()) {
				System.out.println(key);
				EmpVO emp = new EmpVO();
				emp.setEmail(key);
				emplist.add(emp);
			}
	}

}
