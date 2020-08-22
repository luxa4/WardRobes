package ru.belyaev.util;

import ru.belyaev.constant.SessionConstant;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;

import javax.servlet.http.HttpSession;
import java.util.HashSet;

public class SessionUtil {

    public static ShoppingCart getShoppingCart(HttpSession session) {
        ShoppingCart currentShoppingCart = (ShoppingCart) session.getAttribute(SessionConstant.SHOPPING_CART.toString());

        if (currentShoppingCart == null) {
            currentShoppingCart = new ShoppingCart();
            currentShoppingCart.setShoppingCartItems(new HashSet<>());
            session.setAttribute("currentShoppingCart", currentShoppingCart);
        }
        return currentShoppingCart;
    }

    public static void setCurrentShoppingCart(HttpSession session, ShoppingCart shoppingCart) {
        session.setAttribute(SessionConstant.SHOPPING_CART.toString(), shoppingCart);
    }

    public static void clearCurrentShoppingCart(HttpSession session) {
        session.removeAttribute(SessionConstant.SHOPPING_CART.toString());
    }

    public static void setCurrentUser(HttpSession httpSession, User user) {
        httpSession.setAttribute(SessionConstant.USER.toString(), user);
    }

    public static User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute(SessionConstant.USER.toString());
    }

}
