package com.hexaware.InsuranceClaimManagement.controllers;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;
import com.hexaware.InsuranceClaimManagement.services.ClaimDocServices;
import com.hexaware.InsuranceClaimManagement.services.ClaimServices;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimDocControllerSyntax;


@RequestMapping("/api/v1/claim/")
@RestController
public class ClaimDocController implements ClaimDocControllerSyntax{
	
	@Autowired
	private ClaimDocServices DocServ;
	@Autowired
	private ClaimServices ClaimServ;
	
	public ClaimDocController() {
		// TODO Auto-generated constructor stub
		
	}

	@PostMapping("document")
	public ResponseEntity<ClaimDoc> uploadDoc(@RequestParam("file") MultipartFile doc, @RequestParam("ClaimId") long ClaimId ) {
		System.out.println("############################################");
		System.out.println("Uploaded file");
		ClaimDoc newDoc = DocServ.convertingToClaimDoc(doc);
		Claim claim = ClaimServ.showClaimById(ClaimId);
		claim.setStatus("Submitted");
		claim.setUpdateDate( LocalDateTime.now() );
		newDoc.setClaim( claim );
		ClaimServ.updateClaim(claim);
//		newDoc.setClaimUrl(ClaimServ.showClaimById(ClaimId).getUrl());
		return new ResponseEntity<>(DocServ.storeFile(newDoc),HttpStatus.OK);
	}

	@GetMapping("document/{id}")
	public ResponseEntity<Resource> downloadDoc(@PathVariable long id) {
		// TODO Auto-generated method stub
		ClaimDoc doc = DocServ.getClaimDoc(id);
		System.out.println("##########################################################");
		System.out.println(doc.getName());
		return 	doc!=null?
				ResponseEntity.ok()
					.contentType( MediaType.parseMediaType( doc.getDataType() ) )
					.header( HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getName() + "\"" ) 
					.body ( new ByteArrayResource( doc.getData() ) ) 
				: 
				null
		;
		
	}

	@DeleteMapping("document")
	public ResponseEntity<List<ClaimDoc>> deleteDoc(@Validated @RequestBody ClaimDoc doc) {
		// TODO Auto-generated method stub
		Claim c = DocServ.deleteDoc(doc);
		
		return  c != null?
				new ResponseEntity<>(ClaimServ.showClaimById(c.getId()).getDocs(),HttpStatus.OK)
				:
				null;
	}
	
	
	
}
;