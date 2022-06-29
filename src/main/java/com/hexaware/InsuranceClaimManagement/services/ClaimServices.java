package com.hexaware.InsuranceClaimManagement.services;

import java.util.List;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;

public interface ClaimServices {
	public void creatClaim(Claim c);
	
	public Claim updateClaim (Claim c);
	
	public void deleteClaim (Claim c);
	
	public List<Claim> showAllClaim();
	public List<Claim> filterClaim(String keywords);
	public List<Claim> sortingClaim();
}
