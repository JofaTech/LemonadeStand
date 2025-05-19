package lemonadestand.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Lemonade implements Serializable, Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6858462398572875916L;
	
	private Integer id;
	private double lemonJuice;
	private double water;
	private double sugar;
	private int iceCubes;
	private double price;
	private Order order;
	
	// Ignore the CUP variable for .json deserialization (through Jackson)
	@JsonIgnore
	private final int CUP = 1;
	
	
	public Lemonade() {
	}

	public Lemonade(double lemonJuice, double water, double sugar, int iceCubes, Order order) {
		super();
		this.lemonJuice = lemonJuice;
		this.water = water;
		this.sugar = sugar;
		this.iceCubes = iceCubes;
		this.order = order;
		price = (lemonJuice * 0.3) + (sugar * 0.15) + (CUP * 0.5);
	}

	public Lemonade(Integer id, double lemonJuice, double price, double sugar, int iceCubes, double water, Order order) {
		this.id = id;
		this.lemonJuice = lemonJuice;
		this.price = price;
		this.sugar = sugar;
		this.iceCubes = iceCubes;
		this.water = water;
		this.order = order;
	}

	public double getLemonJuice() {
		return lemonJuice;
	}

	public double getWater() {
		return water;
	}

	public double getSugar() {
		return sugar;
	}

	public int getIceCubes() {
		return iceCubes;
	}

	@JsonIgnore
	public int getCUP() {
		return CUP;
	}

	public double getPrice() {
		return price;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setLemonJuice(double lemonJuice) {
		this.lemonJuice = lemonJuice;
	}

	public void setWater(double water) {
		this.water = water;
	}

	public void setSugar(double sugar) {
		this.sugar = sugar;
	}

	public void setIceCubes(int iceCubes) {
		this.iceCubes = iceCubes;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CUP, iceCubes, lemonJuice, price, sugar, water);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lemonade other = (Lemonade) obj;
		return CUP == other.CUP && iceCubes == other.iceCubes
				&& Double.doubleToLongBits(lemonJuice) == Double.doubleToLongBits(other.lemonJuice)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Double.doubleToLongBits(sugar) == Double.doubleToLongBits(other.sugar)
				&& Double.doubleToLongBits(water) == Double.doubleToLongBits(other.water);
	}

	@Override
	public String toString() {
		return "Lemonade {lemonJuice=" + lemonJuice + ", water=" + water + ", sugar=" + sugar + ", iceCubes=" + iceCubes
				+ ", CUP=" + CUP + ", price=" + price + "}";
	}
	
	
		
}
