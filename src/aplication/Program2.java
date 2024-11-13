package aplication;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TESTE 1: department findyById ===");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		
		System.out.println("\n === TESTE 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n === TESTE 3: department insert ===");
		Department newDepartment = new Department(null, "Health");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n === TESTE 4: department update ===");
		department = departmentDao.findById(1);
		department.setName("Music");
		departmentDao.update(department);
		System.out.println("Update completed");
		
		System.out.println("\n === TESTE 5: department delete ===");
		System.out.println("Enter id for delete teste: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
