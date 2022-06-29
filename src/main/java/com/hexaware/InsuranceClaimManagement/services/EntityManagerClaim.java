package com.hexaware.InsuranceClaimManagement.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimServicesSyntax;

@Repository
@Transactional
public class EntityManagerClaim {
	
	@PersistenceContext
	EntityManager em;
	public EntityManagerClaim() {
		// TODO Auto-generated constructor stub
	}

	public void createClaim(Claim c) {
		
	}

	
	public List<Claim> showAllClaim() {
		
		return em.createNativeQuery("select * from CLAIMS").getResultList();
	}
	
	public Claim showClaimById(long id) {
		
		return em.find(Claim.class,id);
	}
	
	public List<Claim> filterClaim(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Claim> sortingClaim() {
		// TODO Auto-generated method stub
		return null;
	}

	public Claim updateClaim(Claim c) {
		// TODO Auto-generated method stub
		return em.merge(c);
	}

	public void deleteClaim(Claim c) {
		// TODO Auto-generated method stub
		em.remove(c);
	}

	
	
}
