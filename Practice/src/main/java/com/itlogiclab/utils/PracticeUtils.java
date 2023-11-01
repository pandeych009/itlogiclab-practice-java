package com.itlogiclab.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;


public class PracticeUtils {

	private static final Logger logger = LogManager.getLogger(PracticeUtils.class);

	public static final String USER_AGENT = "Mozilla/5.0";

	public static Set<Integer> generateNumber(int limit, int max){
		//Set<Integer> numbers = IntStream.rangeClosed(1, limit).peek(input -> System.out.print("Stream: "+input+"\n")).boxed().map(input ->  ThreadLocalRandom.current().nextInt(input, max)).peek(input -> System.out.print("Random: "+input+"\n")).collect(Collectors.toSet());
		Set<Integer> numbers = IntStream.rangeClosed(1, limit).boxed().map(input ->  ThreadLocalRandom.current().nextInt(input, max)).collect(Collectors.toSet());
		logger.debug("Generation random: "+numbers);
		print(numbers);
		return numbers;
	}

	public static String readDataFromSource(InputStream stream) throws IOException {
		StringBuffer response = new StringBuffer();
		try(BufferedReader in = new BufferedReader(new InputStreamReader(stream))){
			String line = null;
			while(Objects.nonNull(line = in.readLine())) {
				response.append(line);
				response.append(System.lineSeparator());
			}
		}
		return response.toString();
	}


	public static <T> void print(Collection<T> numbers) {
		StringBuilder builder = new StringBuilder();
		numbers.forEach(input -> {
			builder.append(input);
			builder.append(" ,");
		});
		builder.deleteCharAt(builder.length() - 1);
		logger.debug(builder.toString());
	}

	public static Map<String, Object> sendPostRequest(final String url, final String payload, final String contentType, String requestMethod) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// Setting basic post request
		con.setRequestMethod(requestMethod);
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-Type",contentType);
		//contentType = "application/json"

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(payload);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		logger.debug("\nSending 'POST' request to URL : " + url);
		logger.debug("Response Code : " + responseCode);

		String response = PracticeUtils.readDataFromSource(con.getInputStream());
		//printing result from response
		logger.debug(FileFormatConvertorUtils.prettyPrintJSON(response.toString()) );


		Map<String, Object> map = new HashMap<>();
		map.put("RESPONSE_CODE", responseCode);
		map.put("RESPONSE_OBJECT", response);

		return map;
	}

	public static String sendGetRequest(final String url, String contentType) {
		StringBuilder content = null;

		HttpURLConnection connection = null;
		URL messageURL = null;
		try {

			messageURL = new URL(url);
			connection = (HttpURLConnection)messageURL.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent", USER_AGENT);
			connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			connection.setRequestProperty("Content-Type",contentType);

			int status = connection.getResponseCode();
			InputStream stream = null;
			if(status == 200) {
				logger.debug("Connection established for GET request: Reading Success Stream" );
				stream = connection.getInputStream();
			}else {
				logger.debug("Connection established for GET request: Reading Error Stream" );
				stream = connection.getErrorStream();
			}
			content = readStream(stream);

		} catch (IOException e) {
			logger.error("Exception occured while establising connection to URL: "+url);
		}finally {
			if(Objects.nonNull(connection)) {
				connection.disconnect();				
			}
		}
		return content.toString();
	}

	private static StringBuilder readStream(InputStream stream) throws IOException {
		StringBuilder content = new StringBuilder();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(stream))){
			String line = null;
			while(Objects.nonNull(line = br.readLine())) {
				content.append(line);
				content.append(System.lineSeparator());
			}
		}

		return content;
	}

	public static Map<String, Object> executePost(final String url, final String payload, final String contentType, String requestMethod, boolean check) throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		try (CloseableHttpClient httpClient = HttpClients.createDefault()){
			HttpPost request = new HttpPost(url); 


		}



		return null;

	}


	private static void sendPOST() throws IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("");
		httpPost.addHeader("User-Agent", USER_AGENT);

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("userName", "Pankaj Kumar"));

		HttpEntity postParams = new UrlEncodedFormEntity(urlParameters);
		httpPost.setEntity(postParams);

		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

		System.out.println("POST Response Status:: " + httpResponse.getStatusLine().getStatusCode());

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));

		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();

		// print result
		System.out.println(response.toString());
		httpClient.close();

	}


	public static String generateJSONSChema() throws JsonProcessingException {
		ObjectMapper jacksonMapper = new ObjectMapper();
		JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(jacksonMapper);
		JsonSchema schema = schemaGen.generateSchema(Object.class);

		String schemaString = jacksonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(schema);
		System.out.println(schemaString);

		return null;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		generateJSONSChema();
	}

}


