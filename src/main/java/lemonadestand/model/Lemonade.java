package lemonadestand.model;

import java.util.Objects;

public class Lemonade {

	private double lemonJuice;
	private double water;
	private double sugar;
	private int iceCubes;
	private final int CUP = 1;
	private double price;
	
	public Lemonade(double lemonJuice, double water, double sugar, int iceCubes) {
		super();
		this.lemonJuice = lemonJuice;
		this.water = water;
		this.sugar = sugar;
		this.iceCubes = iceCubes;
		calculatePrice();
	}
	
	private void calculatePrice() {
		price = (lemonJuice * 0.3) + (sugar * 0.15) + (CUP * 0.5);
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

	public int getCUP() {
		return CUP;
	}

	public double getPrice() {
		return price;
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
		return "Lemonade [lemonJuice=" + lemonJuice + ", water=" + water + ", sugar=" + sugar + ", iceCubes=" + iceCubes
				+ ", CUP=" + CUP + ", price=" + price + "]";
	}
	
	
		
}
