package lemonadestand.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4546622142954731428L;
	
	private Customer customer;
	private List<Lemonade> lemonades;
	private double total;
	private Integer id;
	private LemonadeStand lemonadeStand;

	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new ArrayList<>();
		total = 0.0;
	}

	public Order() {
	}
	
	public Order(Customer customer, LemonadeStand lemonadeStand) {
		this.customer = customer;
		this.lemonadeStand = lemonadeStand;
	}
	
	public Order(Integer id, double total, Customer customer, LemonadeStand lemonadeStand) {
		this.id = id;
		this.total = total;
		this.customer = customer;
		this.lemonadeStand = lemonadeStand;
	}

	public void addLemonade(Lemonade lemonade) {
		if (lemonades == null) {
			lemonades = new ArrayList<>();
		}
		lemonades.add(lemonade);
		total += lemonade.getPrice();
	}

	public void addLemonades(List<Lemonade> lemonades) {
		if (lemonades == null) {
			lemonades = new ArrayList<>();
		}
		this.lemonades.addAll(lemonades);
		for (Lemonade l : lemonades) {
			total += l.getPrice();
		}	
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Lemonade> getLemonades() {
		if (lemonades == null) {
			lemonades = new ArrayList<>();
		}
		return lemonades;
	}

	public double getTotal() {
		return total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setLemonades(List<Lemonade> lemonades) {
		this.lemonades = lemonades;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LemonadeStand getLemonadeStand() {
		return lemonadeStand;
	}

	public void setLemonadeStand(LemonadeStand lemonadeStand) {
		this.lemonadeStand = lemonadeStand;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lemonades.hashCode();
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return customer.equals(other.customer) && lemonades.equals(other.getLemonades())
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}

	@Override
	public String toString() {
		return "Order {customer=" + customer + ", lemonades=" + lemonades.toString() + ", total=" + total + "}";
	}

}
