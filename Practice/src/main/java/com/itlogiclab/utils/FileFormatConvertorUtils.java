package com.itlogiclab.utils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class FileFormatConvertorUtils<T> {


	public String getJSON(T request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
		System.out.println(str);
		return str;
	}



	public static String prettyPrintJSON(String ugly) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonElement je = JsonParser.parseString(ugly);
		String prettyJsonString = gson.toJson(je);
		return prettyJsonString;
	}
	
	public void convertCSV() throws JsonProcessingException, IOException {
		JsonNode jsonTree = new ObjectMapper().readTree(new File("src/main/resources/Question.json"));
		com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
		JsonNode firstObject = jsonTree.elements().next();
		
		Iterator<JsonNode> nodes = jsonTree.elements();
		while(nodes.hasNext()) {
			JsonNode node = nodes.next();
			System.out.println(node.asText());
			
		}
		
		
		
		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
		
		CsvMapper mapper = new CsvMapper();
		mapper.writerFor(JsonNode.class).with(csvSchema).writeValue(new File("src/main/resources/Question_convert.csv"), jsonTree);
		
	}

	
	public static void main(String[] args) throws JsonProcessingException, IOException {
		FileFormatConvertorUtils util = new FileFormatConvertorUtils<>();
		util.convertCSV();
	}
	
}
