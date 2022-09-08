package com.info.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;
	
	@Column
	private String itemName;
	
	private String itemDescription;
		
	private String image;
	@Column
	private String itemPhoneNumber;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "region_id")
	private Region region = new Region();
	
	
	public Region getRegion() {
		return region;
	}


	public void setRegion(Region region) {
		this.region = region;
	}


	public String getItemPhoneNumber() {
		return itemPhoneNumber;
	}


	public void setItemPhoneNumber(String itemPhoneNumber) {
		this.itemPhoneNumber = itemPhoneNumber;
	}


	public Item() {
		this.itemName = "";
		this.itemDescription = "";
	}
	

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}



	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}




	
	
}