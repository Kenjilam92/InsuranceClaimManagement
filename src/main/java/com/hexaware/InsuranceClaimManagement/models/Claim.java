package com.hexaware.InsuranceClaimManagement.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="Claims")
public class Claim {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="title")
	private String title;
	@Column (name="description")
	private String description;
	@Column(name="status")
	private String status;
	@OneToMany(
			mappedBy="claim",
			cascade = CascadeType.ALL, 
			orphanRemoval = true,
			fetch=FetchType.LAZY
			)
	private List<ClaimDoc> docs;
	@Column(name="url")
	private String url;
	@CreationTimestamp
	private LocalDateTime createdDate;
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	public Claim() {
		// TODO Auto-generated constructor stub
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<ClaimDoc> getDocs() {
		return docs;
	}


	public void setDocs(List<ClaimDoc> docs) {
		this.docs = docs;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String desc) {
		this.description = desc;
	}


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


	@Override
	public String toString() {
		return "Claim [id=" + id + ", title=" + title + ", desc=" + description + ", status=" + status + ", docs=" + docs
				+ ", url=" + url + ", createdDate=" + createdDate + ", updateDate=" + updateDate + "]";
	}
	
}
