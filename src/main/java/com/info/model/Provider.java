package com.info.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provider")
public class Provider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long providerId;
	
	private String providerName;
	
	private String providerDescription;
	
	private String image;
	
	private int providerNum;
	
	@OneToMany(mappedBy = "provider", cascade = CascadeType.ALL)
	private List<Product> productList;

	public long getProviderId() {
		return providerId;
	}

	public void setProviderId(long providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public String getProviderDescription() {
		return providerDescription;
	}

	public void setProviderDescription(String providerDescription) {
		this.providerDescription = providerDescription;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getProviderNum() {
		return providerNum;
	}

	public void setProviderNum(int providerNum) {
		this.providerNum = providerNum;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
}