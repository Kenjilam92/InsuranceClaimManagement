package com.hexaware.InsuranceClaimManagement.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hexaware.InsuranceClaimManagement.models.Claim;
import com.hexaware.InsuranceClaimManagement.models.ClaimDoc;
import com.hexaware.InsuranceClaimManagement.repositories.ClaimDocsRespository;
import com.hexaware.InsuranceClaimManagement.syntaxInterface.ClaimDocsServicesSyntax;

@Service
public class ClaimDocServices implements ClaimDocsServicesSyntax {
	
	@Autowired
	private ClaimDocsRespository repo;
	
	private String rootAPI = "api/v1/claim/document/";
	
	@Override
	public ClaimDoc convertingToClaimDoc(MultipartFile doc) {
		
		
//		getBytes[]
//		getContentType()
//		getName()/ getOriginalFilename()?
//		getSize() (long integer)
//		isEmpty()

		try {
			return new ClaimDoc(
					doc.getOriginalFilename(),
					doc.getContentType(),
					doc.getSize(),
					doc.getBytes()
			);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ClaimDoc storeFile(ClaimDoc doc) {
		ClaimDoc newDoc = repo.save(doc);
		newDoc.setUrl(rootAPI+newDoc.getId());
		return repo.save(newDoc);
	}

	@Override
	public ClaimDoc downloadDoc(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public List<ClaimDoc> showDocByClaim(Claim c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaimDoc> deleteDoc(ClaimDoc doc) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
