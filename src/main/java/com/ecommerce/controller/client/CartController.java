package com.ecommerce.controller.client;

import com.ecommerce.model.Cart;
import com.ecommerce.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        ArrayList<Cart> cartItems = new ArrayList<>();
            cartItems = new ArrayList<>();
            
            // Thêm các sản phẩm mẫu vào giỏ hàng
            cartItems.add(new Cart(new Product(
                1, 
                "Clean Code", 
                "A Handbook of Agile Software Craftsmanship by Robert C. Martin", 
                "https://m.media-amazon.com/images/I/41xShlnTZTL.jpg", 
                45.99
            ), 1));
            
            cartItems.add(new Cart(new Product(
                2, 
                "Java: The Complete Reference", 
                "Comprehensive guide to Java programming by Herbert Schildt", 
                "https://m.media-amazon.com/images/I/41xShlnTZTL.jpg", 
                55.50
            ), 2));
            
            cartItems.add(new Cart(new Product(
                3, 
                "Python Crash Course", 
                "A fast-paced introduction to programming with Python by Eric Matthes", 
                "https://m.media-amazon.com/images/I/41as+WafrFL.jpg", 
                39.95
            ), 1));
          
        
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("cartTotal", 1000);

        request.getRequestDispatcher("/views/client/cart.jsp").forward(request, response);
    }
}
