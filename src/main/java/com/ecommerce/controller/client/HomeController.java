package com.ecommerce.controller.client;

import com.ecommerce.model.Product;
import com.ecommerce.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
//        ProductDAO productDAO = new ProductDAO();
//        List<Product> productList = productDAO.getAllProducts();
        ArrayList<Product> productList = new ArrayList<>();
     // Sản phẩm 1
        productList.add(new Product(
            1, 
            "Clean Code", 
            "A Handbook of Agile Software Craftsmanship by Robert C. Martin", 
            "https://m.media-amazon.com/images/I/41xShlnTZTL.jpg", 
            45.99
        ));
        
        // Sản phẩm 2
        productList.add(new Product(
            2, 
            "Java: The Complete Reference", 
            "Comprehensive guide to Java programming by Herbert Schildt", 
            "https://m.media-amazon.com/images/I/41xShlnTZTL.jpg", 
            55.50
        ));
        
        // Sản phẩm 3
        productList.add(new Product(
            3, 
            "Python Crash Course", 
            "A fast-paced introduction to programming with Python by Eric Matthes", 
            "https://m.media-amazon.com/images/I/41as+WafrFL.jpg", 
            39.95
        ));
        
        // Sản phẩm 4
        productList.add(new Product(
            4, 
            "The Pragmatic Programmer", 
            "Your journey to mastery, by Andrew Hunt and David Thomas", 
            "https://m.media-amazon.com/images/I/518FqJvR9aL.jpg", 
            42.00
        ));
        
        // Sản phẩm 5
        productList.add(new Product(
            5, 
            "Introduction to Algorithms", 
            "Comprehensive introduction to algorithms, by Thomas H. Cormen", 
            "https://m.media-amazon.com/images/I/41as+WafrFL.jpg", 
            75.99
        ));

        request.setAttribute("productList", productList);
        
        request.getRequestDispatcher("/views/client/home.jsp").forward(request, response);
    }
}
