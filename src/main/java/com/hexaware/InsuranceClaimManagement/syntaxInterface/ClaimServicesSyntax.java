package com.hexaware.InsuranceClaimManagement.syntaxInterface;

import java.util.List;
import java.util.Optional;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;

public interface ClaimServicesSyntax {
	public Claim createClaim(Claim c);
	
	public Claim updateClaim (Claim c);
	
	public List<Claim> deleteClaim (Claim c);
	
	public List<Claim> showAllClaim();
	public Claim showClaimById(long id);
	
	public List<Claim> filterClaim(String keywords);
	public List<Claim> sortingClaim();
}
