package com.sedatram.model.auxiliar;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sedatram.model.Formality;

@Entity
public class FormalityComment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@Column(length = 512)
	private String comment;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_formality")
    private Formality formality;
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	private String editedBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date editedAt;
	
	public String getComment() {
		return comment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public Date getDate() {
		return date;
	}
	public Date getEditedAt() {
		return editedAt;
	}
	public String getEditedBy() {
		return editedBy;
	}
	public Formality getFormality() {
		return formality;
	}
	public int getId() {
		return id;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setEditedAt(Date editedAt) {
		this.editedAt = editedAt;
	}
	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}
	public void setFormality(Formality formality) {
		this.formality = formality;
	}
	public void setId(int id) {
		this.id = id;
	}
}
