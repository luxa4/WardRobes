package ru.belyaev.service.impl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.belyaev.config.ApplicationConfig;
import ru.belyaev.entity.*;
import ru.belyaev.exception.InternalServerErrorException;
import ru.belyaev.repository.OrderRepository;
import ru.belyaev.repository.ShoppingCartRepository;

import java.util.HashSet;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
public class OrderServiceImplTest extends AbstractTestNGSpringContextTests {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private ShoppingCartRepository shoppingCartRepository;

    @Mock
    private OrderRepository orderRepository;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expectedExceptions = InternalServerErrorException.class)
    public void shouldThrowExceptionWhenShoppingCartIsNull() {
        User user = new User();
        Order order = new Order();
        when(shoppingCartRepository.findShoppingCartByUser(user)).thenReturn(null);
        orderService.makeOrder(order, user);
    }

    @Test
    public void testMakeOrder() {
        User user = new User();
        Order order = new Order();
        ShoppingCart shoppingCart = new ShoppingCart();
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setProduct(new Product());
        shoppingCartItem.setShoppingCart(shoppingCart);
        shoppingCartItem.setCount(2);
        HashSet<ShoppingCartItem> list = new HashSet();
        list.add(shoppingCartItem);
        shoppingCart.setShoppingCartItems(list);
        when(shoppingCartRepository.findShoppingCartByUser(user)).thenReturn(shoppingCart);
        orderService.makeOrder(order, user);
        verify(shoppingCartRepository, times(1)).findShoppingCartByUser(user);
        verify(orderRepository, times(1)).save(order);
        verify(shoppingCartRepository, times(1)).delete(shoppingCart);
    }
}