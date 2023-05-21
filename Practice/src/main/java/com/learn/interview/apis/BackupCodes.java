package com.learn.interview.apis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;

public class BackupCodes {

	public AccessToken getToken() throws IOException, FileNotFoundException {
		GoogleCredentials googleCred = null;
		googleCred = GoogleCredentials.fromStream(new FileInputStream(""));
		GoogleCredentials scoped = googleCred.createScoped(
				Arrays.asList(
						"https://www.googleapis.com/auth/firebase.database",  
						"https://www.googleapis.com/auth/userinfo.email"
						)
				);
		scoped.refreshAccessToken();
		AccessToken token = scoped.getAccessToken();

		return token;
	}
	
}
