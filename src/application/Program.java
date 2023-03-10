package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller =  sellerDao.findById(3); 
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		Department depato = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(depato);
		
		for(Seller x : list) {
			System.out.println(x);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		List<Seller> listAll = sellerDao.findAll();
		
		for(Seller x : listAll) {
			System.out.println(x);
		}
		
//		System.out.println("\n=== TEST 4: seller insert ===");
//		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, depato);
//		sellerDao.insert(newSeller);
//		
//		System.out.println("INSERTED! New id= " + newSeller.getId());
		
		
		System.out.println("\n=== TEST 5: seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");;
		sellerDao.update(seller);
		System.out.println("UPDATE COMPLETED");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		System.out.print("Enter id for deletion: ");
		int idForDeletion = sc.nextInt();
		sellerDao.deleteById(idForDeletion);
		
		
	}

}
