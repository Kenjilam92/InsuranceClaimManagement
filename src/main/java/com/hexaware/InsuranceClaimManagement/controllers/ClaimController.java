package com.hexaware.InsuranceClaimManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.services.ClaimServices;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimControllerSyntax;


@RestController
@RequestMapping(value = "/api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClaimController implements ClaimControllerSyntax{
	
	
	public ClaimController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private ClaimServices ClaimServ;

	@GetMapping(path="claims")
	public ResponseEntity<List<Claim>> showAllClaim() {
		
		return new ResponseEntity<>(ClaimServ.showAllClaim(),HttpStatus.OK);
	}

	@GetMapping("claim/{id}")
	public ResponseEntity<Claim> getClaimById(@PathVariable long id) {
		
		return new ResponseEntity<>(ClaimServ.showClaimById(id),HttpStatus.OK);
	}

	@PostMapping("claim")
	public ResponseEntity<Claim> createClaim(@Validated @RequestBody Claim c) {
		System.out.println("##############################");
		System.out.println(c);
		return new ResponseEntity<>(ClaimServ.createClaim(c),HttpStatus.OK);
	}

	@PutMapping("claim")
	public ResponseEntity<Claim> updateClaim(@Validated @RequestBody Claim c) {
		System.out.println("##############################");
		System.out.println(c);
		return new ResponseEntity<>(ClaimServ.updateClaim(c),HttpStatus.OK);
	}

	@DeleteMapping("claim")
	public ResponseEntity<List<Claim>> deletedClaim(@Validated @RequestBody Claim c) {
		
		return new ResponseEntity<>(ClaimServ.deleteClaim(c),HttpStatus.OK);
	}
	
	

	
}
