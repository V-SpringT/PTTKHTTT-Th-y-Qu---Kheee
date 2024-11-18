package com.ecommerce.dao;

import com.ecommerce.model.Product;
import com.ecommerce.model.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartDAO {
    private List<CartItem> cartItems;

    public CartDAO() {
        this.cartItems = new ArrayList<>();
    }

    // Lấy danh sách sản phẩm trong giỏ hàng
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    // Thêm sản phẩm vào giỏ hàng
    public void addProduct(Product product, int quantity) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst();

        if (existingItem.isPresent()) {
            // Nếu sản phẩm đã có trong giỏ, cập nhật số lượng
            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {
            // Nếu sản phẩm chưa có trong giỏ, thêm mới
            cartItems.add(new CartItem(product, quantity));
        }
    }

    // Xóa sản phẩm khỏi giỏ hàng
    public void removeProduct(int productId) {
        cartItems.removeIf(item -> item.getProduct().getId() == productId);
    }

    // Cập nhật số lượng sản phẩm
    public void updateQuantity(int productId, int quantity) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == productId) {
                item.setQuantity(quantity);
                break;
            }
        }
    }

    // Tính tổng giá trị của giỏ hàng
    public double getCartTotal() {
        return cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    // Xóa tất cả các sản phẩm khỏi giỏ hàng
    public void clearCart() {
        cartItems.clear();
    }
}
