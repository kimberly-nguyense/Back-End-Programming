package com.example.demo.services;

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

    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase){
        if (purchase.getCartItems().isEmpty()){
            return new PurchaseResponse("Cart is empty!");
        }
        Cart cart = purchase.getCart();

        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();

//        cartItems.forEach(cartItem -> {cartItem.setCart(cart)});
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
            item.getExcursions().forEach(excursion -> {
                excursion.setVacation(item.getVacation());
                excursion.getCartitems().add(item);
            });
        });

        Customer customer = purchase.getCustomer();
        customer.add(cart);
        cart.setStatus(Cart.StatusType.ordered);

        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }
    private String generateOrderTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}
