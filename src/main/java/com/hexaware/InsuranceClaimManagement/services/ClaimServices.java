package com.hexaware.InsuranceClaimManagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.repositories.ClaimRespository;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimServicesSyntax;

@Service
public class ClaimServices implements ClaimServicesSyntax {

	@Autowired
	ClaimRespository repo;
	private String rootAPI = "/api/v1/";
	
	@Override
	public Claim createClaim(Claim c) {
		Claim newClaim = repo.save(c);
		newClaim.setUrl(rootAPI+"claim/"+newClaim.getId());
		return repo.save(newClaim);
//		return repo.save(c);
	}

	@Override
	public Claim updateClaim(Claim c) {
		return repo.save(c);
	}

	@Override
	public List<Claim> deleteClaim(Claim c) {
		repo.delete(c);
		return showAllClaim();
	}

	@Override
	public List<Claim> showAllClaim() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Claim showClaimById(long id) {
		// TODO Auto-generated method stub
		Optional<Claim> result = repo.findById(id);
		
		return result.isPresent()? result.get() : null;
	}

	@Override
	public List<Claim> filterClaim(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> sortingClaim() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
