package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> products = new ArrayList<Product>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int nProducts = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= nProducts; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Commom, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();

			switch (type) {
			case 'c':
				products.add(new Product(name, price));
				break;
			case 'u':
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String manufactureDate = sc.next();
				Date date = sdf.parse(manufactureDate);
				products.add(new UsedProduct(name, price, date));
				break;
			case 'i':
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				products.add(new ImportedProduct(name, price, customsFee));
				break;
			default:
				System.out.println("Invalid option");
			}
		}

		System.out.println();

		for (Product p : products) {
			System.out.println(p.priceTag());
		}
		sc.close();
	}
}
