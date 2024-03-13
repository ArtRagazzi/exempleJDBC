package application;

import model.DAO.DaoFactory;
import model.DAO.DepartmentDAO;
import model.DAO.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        SellerDAO sellerDao = DaoFactory.createSellerDao();
        DepartmentDAO departmentDao = DaoFactory.createDepartmentDao();

        Scanner sc = new Scanner(System.in);
/*
        System.out.println("====== Test 1 FindByID ======");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);


        System.out.println("====== Test 2 FindByDepartmentID ======");
        Department department = new Department(2,null);
        List<Seller> list  = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }


        System.out.println("====== Test 3 FindAll ======");
        list  = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("====== Test 4 Seller Insert ======");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("====== Test 5 Seller Update ======");
        seller = sellerDao.findById(1);
        seller.setName("Marta Pereira");
        sellerDao.update(seller);
        System.out.println("Updated complete!");


        System.out.println("====== Test 6 Seller Delete ======");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete complete");
        sc.close();
        */

        System.out.println("====== Test 1 FindByID ======");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);


        System.out.println("====== Test 3 FindAll ======");
        List<Department> list  = new ArrayList<>();
        list  = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("====== Test 4 Department Insert ======");
        Department newDep = new Department(null,"Music");
        departmentDao.insert(newDep);
        System.out.println("Inserted! New id = " + newDep.getId());

        System.out.println("====== Test 5 Department Update ======");
        dep = departmentDao.findById(1);
        dep.setName("BI");
        departmentDao.update(dep);
        System.out.println("Updated complete!");


        System.out.println("====== Test 6 Seller Delete ======");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete complete");
        sc.close();


    }
}