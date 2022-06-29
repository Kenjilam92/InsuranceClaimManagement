package com.hexaware.InsuranceClaimManagement.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;

@Repository
public interface ClaimDocsRespository extends JpaRepository<ClaimDoc, Long>{
	
	
}
