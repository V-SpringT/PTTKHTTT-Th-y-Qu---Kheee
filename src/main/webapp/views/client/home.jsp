<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home - eCommerce</title>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
    <!-- Header -->
    <header>
    <div class="header-container">
        <div class="logo">
            <a href="/QueProject/home"> 
                <img src="https://png.pngtree.com/template/20210513/ourmid/pngtree-e-commerce-business-logo-image_523441.png" alt="eCommerce Logo">
            </a>
        </div>

        <div class="search-bar">
            <form action="search" method="get">
                <input type="text" name="query" placeholder="Search for products...">
                <button type="submit">Search</button>
            </form>
        </div>
        
        <div class="logout">
            <form action="/QueProject/login" method="get">
                <button type="submit">Log Out</button>
            </form>
        </div>
    </div>
    </header>

    <!-- Body -->
    <div class="body-container">
        <h2>Product List</h2>
        <div class="product-list">
            <c:forEach var="product" items="${productList}">
                <div class="product-item">
                    <img src="${product.imageUrl}" alt="${product.name}" width="150" height="200">
                    <h3>${product.name}</h3>
                    <p>${product.description}</p>
                    <span>Price: ${product.price}</span>
                    <!-- Nút Add to Cart -->
                    <form action="/QueProject/addToCart" method="post">
                        <input type="hidden" name="productId" value="${product.id}">
                        <button type="submit">Add to Cart</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        <div class="footer-container">
            <p>&copy; 2024 eCommerce. All rights reserved.</p>
            <p>Contact us: support@ecommerce.com | Phone: 123-456-7890</p>
        </div>
    </footer>
</body>
</html>
