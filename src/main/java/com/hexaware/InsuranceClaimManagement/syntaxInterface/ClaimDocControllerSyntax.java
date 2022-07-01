package com.hexaware.InsuranceClaimManagement.syntaxInterface;

import java.util.List;

import org.springframework.core.io.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;

public interface ClaimDocControllerSyntax {
	// we will use converter and store at his control
	public ResponseEntity<ClaimDoc> uploadDoc ( MultipartFile doc , long ClaimId );
	
	//user auto download this file when do this url
	
	public ResponseEntity<Resource> downloadDoc (long id);
	
	// Don't know if this is necessary be cause we can view it on Claim database
	// public ResponseEntity<List<ClaimDoc>> viewTheDocByClaim (Long claimId);
	
	// this will refresh the current API of the Claim after we delete a doc
	public ResponseEntity<List<ClaimDoc>> deleteDoc (ClaimDoc doc);
	
}
