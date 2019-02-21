package com.sedatram.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sedatram.model.auxiliar.FormalityComment;
import com.sedatram.model.auxiliar.FormalityHandler;
import com.sedatram.model.auxiliar.TypeFormality;

@Entity
public class Formality {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private int id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_customer")
	private Person customer;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type")
	private TypeFormality type;
	@Temporal(TemporalType.TIMESTAMP)
	private Date initDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehicle")
	private Vehicle vehicle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_handler")
	private FormalityHandler handler;
	private int taxes;
	private int formalityRight;
	private int signaling;
	private int retention;
	private int goodStanding;
	private int others;
	private int handlerService;
	private int serviceSedatram;
	private int shipments;
	private int total;
	private String payStatus;
	private String status;
	@OneToMany(mappedBy = "formality")
	private List<FormalityComment> comments;
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishDate;
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "Formality_Buyer", joinColumns = @JoinColumn(name = "formality_id"), inverseJoinColumns = @JoinColumn(name = "buyer_id"))
	private List<Buyer> buyers;
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	private String editedBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date editedAt;

	public Formality() {
		buyers = new ArrayList<>();
		comments = new ArrayList<>();
	}

	public void addBuyer(Buyer buyer) {
		buyers.add(buyer);
		buyer.getFormalities().add(this);
	}

	public void addComment(FormalityComment comment) {
		comments.add(comment);
		comment.setFormality(this);
	}

	public boolean existBuyer(Buyer buyer) {
		for (Buyer o : buyers) {
			if (o.getIdentification().equals(buyer.getIdentification())) {
				return true;
			}
		}
		return false;
	}

	public List<Buyer> getBuyers() {
		return buyers;
	}

	public List<FormalityComment> getComments() {
		return comments;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Person getCustomer() {
		return customer;
	}

	public Date getEditedAt() {
		return editedAt;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public int getFormalityRight() {
		return formalityRight;
	}

	public int getGoodStanding() {
		return goodStanding;
	}

	public FormalityHandler getHandler() {
		return handler;
	}

	public int getHandlerService() {
		return handlerService;
	}

	public int getId() {
		return id;
	}

	public Date getInitDate() {
		return initDate;
	}

	public int getOthers() {
		return others;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public int getRetention() {
		return retention;
	}

	public int getServiceSedatram() {
		return serviceSedatram;
	}

	public int getShipments() {
		return shipments;
	}

	public int getSignaling() {
		return signaling;
	}

	public String getStatus() {
		return status;
	}

	public int getTaxes() {
		return taxes;
	}

	public int getTotal() {
		return total;
	}

	public TypeFormality getType() {
		return type;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void removeBuyer(Buyer buyer) {
		buyers.remove(buyer);
		buyer.getFormalities().remove(this);
	}

	public void removeComment(FormalityComment comment) {
		comments.remove(comment);
		comment.setFormality(null);
	}

	public void setBuyers(List<Buyer> buyers) {
		this.buyers = buyers;
	}

	public void setComments(List<FormalityComment> comments) {
		this.comments = comments;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public void setEditedAt(Date editedAt) {
		this.editedAt = editedAt;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public void setFormalityRight(int formalityRight) {
		this.formalityRight = formalityRight;
	}

	public void setGoodStanding(int goodStanding) {
		this.goodStanding = goodStanding;
	}

	public void setHandler(FormalityHandler handler) {
		this.handler = handler;
	}

	public void setHandlerService(int handlerService) {
		this.handlerService = handlerService;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public void setRetention(int retention) {
		this.retention = retention;
	}

	public void setServiceSedatram(int serviceSedatram) {
		this.serviceSedatram = serviceSedatram;
	}

	public void setShipments(int shipments) {
		this.shipments = shipments;
	}

	public void setSignaling(int signaling) {
		this.signaling = signaling;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTaxes(int taxes) {
		this.taxes = taxes;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setType(TypeFormality type) {
		this.type = type;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
