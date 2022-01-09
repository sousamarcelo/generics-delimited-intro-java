package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;
import model.service.CalculationService;

public class Program {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<Product>();
		
		String path = "C:\\temp\\test\\productsPerform.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();				
			}
			
			Product x = CalculationService.max(list);
			
			System.out.println("Most Expensive:"); 
			System.out.println(x);
			
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
		}
				
		sc.close();
	}

}
