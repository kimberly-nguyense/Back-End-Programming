package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.entities.dto.Cart;
import com.example.demo.entities.dto.CartItem;
import com.example.demo.entities.dto.Customer;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository){
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){
        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();

        cartItems.forEach(cartItem -> cartItem.setCart(cart));

        Customer customer = purchase.getCustomer();
        customer.add(cart);
        cart.setStatus(Cart.StatusType.ordered);

        customerRepository.save(customer);
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}
