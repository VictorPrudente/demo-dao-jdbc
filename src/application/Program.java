package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.print("Find a seller by its ID: ");
        int id = sc.nextInt();

        Seller seller = sellerDao.findById(id);

        System.out.println(seller);
    }
}
