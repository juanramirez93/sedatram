package com.sedatram.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.TypedQuery;

import com.sedatram.entityManager.EM;
import com.sedatram.entityManager.EntityManagerHandler;
import com.sedatram.model.Buyer;

public class BuyerController extends EM {
	/**
	 * static Singleton instance.
	 */
	private static volatile BuyerController instance;

	/**
	 * Return a singleton instance of BuyerController.
	 */
	public static BuyerController getInstance() {
		// Double lock for thread safety.
		if (instance == null) {
			synchronized (BuyerController.class) {
				if (instance == null) {
					instance = new BuyerController();
				}
			}
		}
		return instance;
	}

	/**
	 * Private constructor for singleton.
	 */
	private BuyerController() {
	}

	public List<Buyer> getAllBuyers() {
		open();
		TypedQuery<Buyer> query = EntityManagerHandler.INSTANCE.getEntityManager()
				.createQuery("SELECT b FROM Buyer b ORDER BY b.identification ASC", Buyer.class);
		List<Buyer> buyers = query.getResultList();
		return sort(buyers);
	}

	public Buyer getBuyer(String text) {
		for (Buyer buyer : getAllBuyers()) {
			if (buyer.getIdentification().equals(text)) {
				return buyer;
			}
		}
		return null;
	}

	public void save(Buyer data) {
		open();
		EntityManagerHandler.INSTANCE.getEntityManager().persist(data);
		EntityManagerHandler.INSTANCE.getEntityManager().getTransaction().commit();
		
	}

	public List<Buyer> sort(List<Buyer> buyers) {
		Collections.sort(buyers, new Comparator<Buyer>() {
			public int compare(Buyer o1, Buyer o2) {
				long result = (extractLong(o1.getIdentification()) - extractLong(o2.getIdentification()));
				if (result > 0) {
					return 1;
				} else {
					return -1;
				}
			}

			long extractLong(String s) {
				String num = s.replaceAll("\\.", "");
				num = num.replaceAll("-", "");
				return Long.valueOf(num);
			}
		});
		return buyers;
	}
}
