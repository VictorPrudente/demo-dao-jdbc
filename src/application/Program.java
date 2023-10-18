package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.print("Find a seller by its ID: ");
        int id = sc.nextInt();

        Seller seller = sellerDao.findById(id);
        System.out.println(seller);
        System.out.println();

        System.out.print("Find a seller by its Department: ");
        Department department = new Department(sc.nextInt(), null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller sel : list) {
            System.out.println(sel);
        }
        System.out.println();


        System.out.println("Find all Sellers.");
        list = sellerDao.findAll();
        for (Seller sel : list) {
            System.out.println(sel);
        }
        System.out.println();
        sc.nextLine();
        System.out.println("Insert a new seller: ");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        Date date = new Date();

        System.out.print("Base Salary: ");
        Double salary = sc.nextDouble();

        System.out.print("Department Id (1-4): ");
        int idDep = sc.nextInt();
        Department dept = new Department(idDep, null);

        Seller newSeller = new Seller(null, name, email, date, salary, dept);
        sellerDao.insert(newSeller);
        System.out.println("Seller inserted. New id = " + newSeller.getId());
        System.out.println();
    }
}
