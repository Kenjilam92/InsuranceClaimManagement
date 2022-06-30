package com.hexaware.InsuranceClaimManagement.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="ClaimsDocs")
public class ClaimDoc {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	@Column(name="type")
	private String dataType;
	@Column(name="size")
	private long size;
	@Column(name="url")
	private String url;
//	@Column (name="claim_url")
//	private String claimUrl;
	@Lob
	private byte[] data;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="claim_id")
	/*
	 *To solve API loop issue, we need to change the setter of claim
	 *instead of return whole object we should return the variable that we it stand out
	 *in this case, I wanted it return the claimUrl  
	 */
	private Claim claim;
	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	
	public ClaimDoc() {
		// TODO Auto-generated constructor stub
	}
	
	public ClaimDoc(String name, String type, long size, byte[] data) {
		this.name=name;
		this.dataType = type;
		this.size = size;
		this.data=data;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	@JsonIgnore
	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

//	public String getClaimUrl() {
//		return claimUrl;
//	}
//
//	public void setClaimUrl(String claimUrl) {
//		this.claimUrl = claimUrl;
//	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	
	public String getClaim() {
		return claim.getUrl();
	}


	public void setClaim(Claim claim) {
		this.claim = claim;
	}
	
	
	
}
