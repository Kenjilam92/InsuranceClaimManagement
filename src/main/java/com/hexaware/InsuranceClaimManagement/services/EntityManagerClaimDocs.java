package com.hexaware.InsuranceClaimManagement.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimDocsServicesSyntax;

@Repository
@Transactional
public class EntityManagerClaimDocs implements ClaimDocsServicesSyntax{
	
	@PersistenceContext
	EntityManager em;
	
	public EntityManagerClaimDocs()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void uploadDoc(ClaimDoc doc) {
		// TODO Auto-generated method stub
		em.persist(doc);
	}

	@Override
	public void uploadMultipleDoc(List<ClaimDoc> docs) {
		// TODO Auto-generated method stub
		docs.stream().forEach(doc -> em.persist(doc));
	}

	@Override
	public void downloadDoc(ClaimDoc doc) {
		// research how to download the file
		
	}

	@Override
	public List<ClaimDoc> showDocByClaim(Claim c) {
		// we will rely on ClaimRepo to find the Claim  
		return c.getDocs();
	}

	@Override
	public void deleteDoc(ClaimDoc doc) {
		// TODO Auto-generated method stub
		em.remove(doc);
	}
	
}
