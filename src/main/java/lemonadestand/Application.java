package lemonadestand;
import lemonadestand.model.*;

public class Application {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("Slaps", "(999)999-9990");
		Customer customer2 = new Customer("Joe Bob", "(555)555-1234");
		
		Order order1 = new Order(customer1);
		
		order1.addLemonade(new Lemonade(1, 0.5, 1, 5));
		order1.addLemonade(new Lemonade(1, 0.5, 1, 5));
		order1.addLemonade(new Lemonade(1, 0.5, 1, 5));
		order1.addLemonade(new Lemonade(1, 0.5, 1, 5));
		
		for (Lemonade l : order1.getLemonades()) {
			System.out.println("Lemonade price: $" + l.getPrice());
		}
		
		System.out.println("Order 1 Customer Name: " + order1.getCustomer().getName());
		System.out.println("Order 1 Total Price: $" + order1.getTotal());
		
		Order order2 = new Order(customer2);
		
		order2.addLemonade(new Lemonade(1, 2.5, 1, 5));
		order2.addLemonade(new Lemonade(3, 0.5, 1, 5));
		order2.addLemonade(new Lemonade(1, 0.5, 4, 5));
		order2.addLemonade(new Lemonade(2, 1.5, 1.75, 5));
		
		for (Lemonade l : order2.getLemonades()) {
			System.out.println("Lemonade price: $" + l.getPrice());
		}
		
		System.out.println("Order 2 Customer Name: " + order2.getCustomer().getName());
		System.out.println("Order 2 Total Price: $" + order2.getTotal());

	}

}
