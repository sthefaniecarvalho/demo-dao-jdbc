package applications;

import java.time.LocalDateTime;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "book");
		System.out.println(obj);
		
		Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDateTime.now(), 3000.00,
				obj);
		System.out.println(seller);

	}

}
