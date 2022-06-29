package com.hexaware.InsuranceClaimManagement.syntaxInterface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hexaware.InsuranceClaimManagement.models.Claim;


public interface ClaimControllerSyntax {
	
	public ResponseEntity<List<Claim>> showAllClaim();
	public ResponseEntity<Claim> getClaimById(long id);
	public ResponseEntity<Claim> createClaim(Claim c);
	public ResponseEntity<Claim> updateClaim(Claim c);
	public ResponseEntity<List<Claim>> deletedClaim(Claim c);
	
}
