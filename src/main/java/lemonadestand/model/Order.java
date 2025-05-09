package lemonadestand.model;

import java.util.Arrays;
import java.util.Objects;

public class Order {

	private Customer customer;
	private Lemonade[] lemonades;
	private double total;
	
	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new Lemonade[0]; 
	}
	
	private void updateTotal() {
		total = 0.0;
		for (Lemonade l : lemonades) {
			total += l.getPrice();
		}
	}
	
	public void addLemonade(Lemonade lemonade) {
		Lemonade[] newLemonadeArray = Arrays.copyOf(lemonades, lemonades.length + 1);		
		newLemonadeArray[newLemonadeArray.length - 1] = lemonade;
		lemonades = newLemonadeArray;
		updateTotal();
	}

	public Customer getCustomer() {
		return customer;
	}

	public Lemonade[] getLemonades() {
		return lemonades;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(lemonades);
		result = prime * result + Objects.hash(customer, total);
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
		return Objects.equals(customer, other.customer) && Arrays.equals(lemonades, other.lemonades)
				&& Double.doubleToLongBits(total) == Double.doubleToLongBits(other.total);
	}

	@Override
	public String toString() {
		return "Order [customer=" + customer + ", lemonades=" + Arrays.toString(lemonades) + ", total=" + total + "]";
	}
	
	
	
}
