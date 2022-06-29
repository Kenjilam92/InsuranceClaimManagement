package com.hexaware.InsuranceClaimManagement.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.services.ClaimServices;

@Repository
@Transactional
public class ClaimRespository implements ClaimServices{
	
	@PersistenceContext
	EntityManager em;
	public ClaimRespository() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creatClaim(Claim c) {
		em.persist(c);
	}

	
	@Override
	public List<Claim> showAllClaim() {
		// TODO Auto-generated method stub
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

	@Override
	public Claim updateClaim(Claim c) {
		// TODO Auto-generated method stub
		return em.merge(c);
	}

	@Override
	public void deleteClaim(Claim c) {
		// TODO Auto-generated method stub
		em.remove(c);
	}
	
}
