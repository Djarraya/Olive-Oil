package com.info.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



	@Entity
	@Table(name = "Panier")
	public class Panier {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long panierId;
		
		@ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name = "user_id")
		private User user = new User();
		
		@ManyToOne(cascade = CascadeType.MERGE)
		@JoinColumn(name = "product_id")
		private Product product = new Product();
		
		int num;
		


		public long getPanierId() {
			return panierId;
		}

		public void setPanierId(long panierId) {
			this.panierId = panierId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}
}
