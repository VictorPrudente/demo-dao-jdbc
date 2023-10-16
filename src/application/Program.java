package application;

import entities.Department;
import entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department books = new Department(1, "Books");

        Seller seller1 = new Seller(21, "Seller 1", "seller@gmail.com", new Date(), 3000.0, books);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println(seller1);
        System.out.println(books);

    }
}
