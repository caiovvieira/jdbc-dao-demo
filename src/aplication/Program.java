package aplication;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 1: seller findyById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n === TESTE 2: seller findyByDepartment ===");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findyByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 3: seller findAll ===");
		list = sellerDao.findyAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 4: seller insert ===");
		Seller newSeller = new Seller(null, "Rebeca", "rebeca@gamil.com", new Date(), 5000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
	}

}
