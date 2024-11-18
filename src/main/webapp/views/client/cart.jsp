<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <link rel="stylesheet" type="text/css" href="css/cart.css">
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
            <h1>Shopping Cart</h1>
            <div class="logout">
                <form action="/QueProject/login" method="get">
                    <button type="submit">Log Out</button>
                </form>
            </div>
        </div>
    </header>

    <!-- Cart Content -->
    <div class="cart-container">
        <h2>Your Cart</h2>
        <c:if test="${not empty cartItems}">
            <table class="cart-table">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Image</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cartItems}">
                        <tr>
                            <td>${item.product.name}</td>
                            <td><img src="${item.product.imageUrl}" alt="${item.product.name}" width="60"></td>
                            <td>
                                <form action="updateCart" method="post">
                                    <input type="hidden" name="productId" value="${item.product.id}">
                                    <input type="number" name="quantity" value="${item.quantity}" min="1">
                                    <button type="submit">Update</button>
                                </form>
                            </td>
                            <td>${item.product.price}</td>
                            <td>${item.totalPrice}</td>
                            <td>
                                <form action="removeFromCart" method="post">
                                    <input type="hidden" name="productId" value="${item.product.id}">
                                    <button type="submit">Remove</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="cart-summary">
                <p>Total Amount: <strong>${cartTotal}</strong></p>
                <form action="checkout" method="get">
                    <button type="submit" class="checkout-button">Proceed to Checkout</button>
                </form>
            </div>
        </c:if>
        
        <c:if test="${empty cartItems}">
            <p>Your cart is empty. <a href="/QueProject/home">Continue shopping</a></p>
        </c:if>
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
