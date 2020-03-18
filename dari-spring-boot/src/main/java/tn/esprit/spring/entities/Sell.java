package tn.esprit.spring.entities;

import javax.persistence.Entity;


@Entity
public class Sell extends Ad{
	private static final long serialVersionUID = 1L;
	
	private float Price;

	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sell(float price) {
		super();
		Price = price;
	}



	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "Sell [Price=" + Price + "]";
	}

	
}
