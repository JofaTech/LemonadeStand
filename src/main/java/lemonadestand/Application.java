package lemonadestand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
//		Box<Order> b1 = new Box<Order>(order1);
//		Box<Customer> b2 = new Box<Customer>(customer2);
//		
//		b1.setObj(order2);
//		
//		b1.getObj().addLemonade(new Lemonade(2, 1.5, 1.75, 5));
//		
//		b2.setObj(customer1);
//		
//		System.out.println(b1.getObj());
//		System.out.println(b2.getObj());
//		
//		b2.printValue(customer2, order1);
		
		LemonadeStand lemonadeStand1 = new LemonadeStand("Brad's First Stand");
		LemonadeStand lemonadeStand2 = new LemonadeStand("Brad's Second Stand");
		
		Map<LemonadeStand, List<Order>> lemonadeStandOrders = new HashMap<>();
		
//		List<Order> lemonadeStand1Orders = new ArrayList<>();
//		lemonadeStand1Orders.add(order1);
		
		lemonadeStandOrders.put(lemonadeStand1, Arrays.asList(new Order[] { order1, order2 }));
		
		lemonadeStandOrders.put(lemonadeStand2,  Arrays.asList(new Order[] { order2 }));
		
		System.out.println(lemonadeStandOrders.get(lemonadeStand1));
		
		System.out.println(lemonadeStandOrders.keySet());

	}

}
