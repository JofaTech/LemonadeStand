package lemonadestand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import lemonadestand.entity.Order;

public class ViewOrder {

	public static void main(String[] args) {

		while (true) {
			Scanner scanner = new Scanner(System.in);

			File file = new File("./orders");

			System.out.println("Which order would you like to view?");

			int orderNumber = 0;

			try {
				orderNumber = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a number less than 2 Billion");
			}

//			// try catch loop for Exception handling (try with resources syntax to ensure
//			// proper closing)
//			try (FileInputStream fileInputStream = new FileInputStream(file + "/order" + orderNumber + ".txt");
//					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
//
//				// Cast readObject to Order type (from default Object type)
//				Order order = (Order) objectInputStream.readObject();
//
//				System.out.println(order.getLemonades());
//				System.out.println("Total= $" + order.getTotal());
//			} catch (FileNotFoundException e) {
//				System.out.println("Order number " + orderNumber + " does not exist.");
//			} catch (IOException e) {
//				System.out.println("Internal IOException.");
//			} catch (ClassNotFoundException e) {
//				System.out.println("Tried to read in an order that isn't formatted correctly.");
//			} catch (ClassCastException e) {
//				System.out.println("The file read does not contain an order.");
//			}
			
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				Order order = objectMapper.readValue(new File(file + "/order" + orderNumber + ".json"), Order.class);
				System.out.println(order.getLemonades());
//				System.out.println("Total= $" + order.getTotal());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
