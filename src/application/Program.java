package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

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


    }
}
