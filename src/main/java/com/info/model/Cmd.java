package com.info.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Cmd {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cmdId;
	
	private long cmdTotale;
	
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> quantity;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date cmdDate;
	
	
	private String cmdEtat;
	@PrePersist
	private void onCreate() {
		
		cmdDate= new Date();
		cmdEtat="En cours";
		
	}


	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user = new User();
	
	@ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "commandeProductList", joinColumns = @JoinColumn(name = "cmdId"), inverseJoinColumns = @JoinColumn(name = "productId"))
	private List<Product> productList;

	
	public String getCmdEtat() {
		return cmdEtat;
	}

	public void setCmdEtat(String cmdEtat) {
		this.cmdEtat = cmdEtat;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	public Date getCmdDate() {
		return cmdDate;
	}

	public void setCmdDate(Date cmdDate) {
		this.cmdDate = cmdDate;
	}
	
	public long getCmdId() {
		return cmdId;
	}

	public void setCmdId(long cmdId) {
		this.cmdId = cmdId;
	}

	public long getCmdTotale() {
		return cmdTotale;
	}

	public void setCmdTotale(long cmdTotale) {
		this.cmdTotale = cmdTotale;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
}
	

