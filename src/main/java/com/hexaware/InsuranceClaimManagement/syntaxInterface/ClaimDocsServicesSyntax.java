package com.hexaware.InsuranceClaimManagement.syntaxInterface;

import java.util.List;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;

public interface ClaimDocsServicesSyntax {
	public void uploadDoc (ClaimDoc doc);
	public void uploadMultipleDoc (List<ClaimDoc> docs);
	public void downloadDoc (ClaimDoc doc);
	
	
	public List<ClaimDoc> showDocByClaim (Claim c) ;
	
	public void deleteDoc (ClaimDoc doc); 
	
	
}
