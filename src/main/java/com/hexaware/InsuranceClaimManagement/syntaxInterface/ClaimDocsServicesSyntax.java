package com.hexaware.InsuranceClaimManagement.syntaxInterface;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;

public interface ClaimDocsServicesSyntax {
	//When user uploading doc the controller will recognize it as a MulipartFile 
	//and we use function to extract info and store it as a ClaimDoc
	public ClaimDoc convertingToClaimDoc (MultipartFile doc);
	
	//To download the file, use just click the url and we will return the file directly. return API is not required.
	public ClaimDoc getClaimDoc (long id);
	
	//After converting the file we can use this function to store new file
	public ClaimDoc storeFile (ClaimDoc doc);
	
	
	// This will delete the file 
	public Claim deleteDoc (ClaimDoc doc); 
	
	//Don't know if this service is necessary because we can view it on claim database
	//yes!! we might need this when delete some doc and refresh the doc list
	//Actually No!! we can use the Claim services to do this task
//	public List<ClaimDoc> showDocByClaim (Claim c) ;
	
	
	//************************************
	// there will be no update file because of security and management purpose. if user want to update just delete the old files
	// there will be no 'show all' doc.  in this application we just show Docs by Claim cases
}
