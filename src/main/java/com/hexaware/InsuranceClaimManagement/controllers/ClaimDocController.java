package com.hexaware.InsuranceClaimManagement.controllers;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;
import com.hexaware.InsuranceClaimManagement.services.ClaimDocServices;
import com.hexaware.InsuranceClaimManagement.services.ClaimServices;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimDocControllerSyntax;


@RequestMapping("/api/v1/claim/")
@RestController
public class ClaimDocController implements ClaimDocControllerSyntax{
	
	private ClaimDocServices DocServ;
	private ClaimServices ClaimServ;
	
	public ClaimDocController() {
		// TODO Auto-generated constructor stub
		
	}

	@PostMapping("document")
	public ResponseEntity<ClaimDoc> uploadDoc(@RequestParam("file") MultipartFile doc, @RequestParam("ClaimId") long ClaimId ) {
		// TODO Auto-generated method stub
		ClaimDoc newDoc = DocServ.convertingToClaimDoc(doc);
		newDoc.setClaim(ClaimServ.showClaimById(ClaimId));
		return new ResponseEntity<>(DocServ.storeFile(newDoc),HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Resource> downloadDoc(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<List<ClaimDoc>> deleteDoc(ClaimDoc doc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
