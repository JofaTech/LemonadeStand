package lemonadestand.model;

//import java.util.ArrayList;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;

public class Order {

	private Customer customer;
	// private List<Lemonade> lemonades;
	private Set<Lemonade> lemonades;
	private double total;

	public Order(Customer customer) {
		super();
		this.customer = customer;
		lemonades = new HashSet<>();
		total = 0.0;
	}

	public void addLemonade(Lemonade lemonade) {
		if (lemonades.add(lemonade)) {
			total += lemonade.getPrice();
		}
	}

	public void addLemonades(Set<Lemonade> lemonades) {
		this.lemonades.addAll(lemonades);
		for (Lemonade l : lemonades) {
			total += l.getPrice();
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public Set<Lemonade> getLemonades() {
		return lemonades;
	}

	public double getTotal() {
		return total;
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
