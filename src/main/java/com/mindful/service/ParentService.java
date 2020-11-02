package com.mindful.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.mindful.dto.Parent;

@Service
public class ParentService {

	//CRUD operations 
	
	//Save Parent to Firestore
	public String saveParent(Parent parent) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Parent")
				.document(parent.getID()).set(parent);
	
		return collectionsApiFuture.get().getUpdateTime().toString(); 
	
	}
	
	//Get Parent from Firestore
	public Parent getParentInfo(String id) throws InterruptedException, ExecutionException
	{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection("Parent").document(id); 
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		
		DocumentSnapshot document = future.get(); 
		
		Parent parent = null; 
		
		if(document.exists()) {
			parent = document.toObject(Parent.class); 
			parent.setID(document.getId());
			return parent; 
		} else {
			return null;
		}
		
	}
	
	//Update Parent info
	public String updateParentInfo(Parent parent) throws InterruptedException, ExecutionException
	{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Parent").document(parent.getID()).set(parent);
		
		return collectionsApiFuture.get().getUpdateTime().toString();
		
	}
	
	//Delete Parent
	public String deleteParent(String id)
	{
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> writeResult = dbFirestore.collection("Parent").document(id).delete();
		return "Document with Parent ID" + id + " has been deleted.";
	}

}
