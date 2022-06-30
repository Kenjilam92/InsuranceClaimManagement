package com.hexaware.InsuranceClaimManagement.services;

import java.time.LocalDateTime;
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
	public Claim createClaim(Claim c) {
		Claim newClaim = repo.save(c);
		newClaim.setUrl(rootAPI+"claim/"+newClaim.getId());
		return repo.save(newClaim);
	}

	@Override
	public Claim updateClaim(Claim c) {
		c.setUpdateDate(LocalDateTime.now());
		Optional<Claim> select = repo.findById(c.getId());
		return select.isPresent()? 
				repo.save( c ) 
				: null;
	}

	@Override
	public List<Claim> deleteClaim(Claim c) {
		Optional<Claim> select = repo.findById(c.getId());
		if (select.isPresent()) {
			repo.delete(select.get());
			return showAllClaim();
		}
		return null;
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
