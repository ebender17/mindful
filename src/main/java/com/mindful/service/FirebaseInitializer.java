package com.mindful.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {

	private void initDB() throws IOException {
		InputStream serviceAccount = this.getClass().getClassLoader()
				.getResourceAsStream("path/to/serviceAccountKey.json");
			
		
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://fir-1651d.firebaseio.com")
					.build(); 
			
			if(FirebaseApp.getApps().isEmpty()) {

				FirebaseApp.initializeApp(options); 
			}
	}
	
	public Firestore getFirebase() {
		return FirestoreClient.getFirestore();
	}
}
