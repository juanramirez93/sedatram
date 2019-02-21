package com.sedatram.model.auxiliar;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeFormality {

	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	private int id;
	@Column(nullable = false)
	private String name;
	private boolean customer = true;
	private boolean vehicle = false;
	private boolean handler = false;
	private boolean taxes = false;
	private boolean rights = false;
	private boolean signaling = false;
	private boolean retention = false;
	private boolean goodStanding = false;
	private boolean others = false;
	private boolean handlerService = false;
	private boolean serviceSedatram = false;
	private boolean shipments = false;
	private boolean total = false;
	private boolean payStatus = false;
	private boolean status = false;
	private boolean finishDate = false;

	public TypeFormality() {
	}

	public TypeFormality(String string) {
		name = string;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isCustomer() {
		return customer;
	}

	public boolean isVehicle() {
		return vehicle;
	}

	public void setCustomer(boolean customer) {
		this.customer = customer;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVehicle(boolean vehicle) {
		this.vehicle = vehicle;
	}

	public boolean isHandler() {
		return handler;
	}

	public void setHandler(boolean handler) {
		this.handler = handler;
	}

	@Override
	public String toString() {
		return name;
	}

	public boolean isTaxes() {
		return taxes;
	}

	public void setTaxes(boolean taxes) {
		this.taxes = taxes;
	}

	public boolean isRights() {
		return rights;
	}

	public void setRights(boolean rights) {
		this.rights = rights;
	}

	public boolean isSignaling() {
		return signaling;
	}

	public void setSignaling(boolean signaling) {
		this.signaling = signaling;
	}

	public boolean isRetention() {
		return retention;
	}

	public void setRetention(boolean retention) {
		this.retention = retention;
	}

	public boolean isGoodStanding() {
		return goodStanding;
	}

	public void setGoodStanding(boolean goodStanding) {
		this.goodStanding = goodStanding;
	}

	public boolean isOthers() {
		return others;
	}

	public void setOthers(boolean others) {
		this.others = others;
	}

	public boolean isHandlerService() {
		return handlerService;
	}

	public void setHandlerService(boolean handlerService) {
		this.handlerService = handlerService;
	}

	public boolean isServiceSedatram() {
		return serviceSedatram;
	}

	public void setServiceSedatram(boolean serviceSedatram) {
		this.serviceSedatram = serviceSedatram;
	}

	public boolean isShipments() {
		return shipments;
	}

	public void setShipments(boolean shipments) {
		this.shipments = shipments;
	}

	public boolean isTotal() {
		return total;
	}

	public void setTotal(boolean total) {
		this.total = total;
	}

	public boolean isPayStatus() {
		return payStatus;
	}

	public void setPayStatus(boolean payStatus) {
		this.payStatus = payStatus;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isFinishDate() {
		return finishDate;
	}

	public void setFinishDate(boolean finishDate) {
		this.finishDate = finishDate;
	}

	public List<Boolean> toArray() {
		List<Boolean> booleans = new ArrayList<Boolean>();
		booleans.add(vehicle);
		booleans.add(handler);
		booleans.add(taxes);
		booleans.add(rights);
		booleans.add(signaling);
		booleans.add(retention);
		booleans.add(goodStanding);
		booleans.add(others);
		booleans.add(handlerService);
		booleans.add(serviceSedatram);
		booleans.add(shipments);
		booleans.add(total);
		booleans.add(payStatus);
		booleans.add(status);
		booleans.add(finishDate);
		return booleans;
	}

	public void setArray(List<Boolean> booleans) {
		vehicle = booleans.get(0);
		handler = booleans.get(1);
		taxes = booleans.get(2);
		rights = booleans.get(3);
		signaling = booleans.get(4);
		retention = booleans.get(5);
		goodStanding = booleans.get(6);
		others = booleans.get(7);
		handlerService = booleans.get(8);
		serviceSedatram = booleans.get(9);
		shipments = booleans.get(10);
		total = booleans.get(11);
		payStatus = booleans.get(12);
		status = booleans.get(13);
		finishDate = booleans.get(14);
	}

}
