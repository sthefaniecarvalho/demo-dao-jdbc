package applications;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "book");
		System.out.println(obj);
		
		Seller seller1 = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00,
				obj);
		System.out.println(seller1);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		System.out.println(sellerDao);
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		

	}

}
