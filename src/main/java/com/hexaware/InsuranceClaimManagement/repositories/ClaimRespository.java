package com.hexaware.InsuranceClaimManagement.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.InsuranceClaimManagement.models.Claim;

@Repository
public interface ClaimRespository extends JpaRepository<Claim, Long> {
	
	
}
