package ru.belyaev.util;

import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SessionUtil {

    public static ShoppingCart getShoppingCart(HttpSession session) {
        ShoppingCart currentShoppingCart = (ShoppingCart) session.getAttribute("currentShoppingCart");

        if (currentShoppingCart == null) {
            currentShoppingCart = new ShoppingCart();
            currentShoppingCart.setShoppingCartItems(new HashSet<>());
            session.setAttribute("currentShoppingCart", currentShoppingCart);
        }
        return currentShoppingCart;
    }

    public static boolean createdShoppingCart(HttpSession session) {
        return session.getAttribute("currentShoppingCart") == null ? false : true;
    }

    public static void setShoppingCart(HttpSession session, ShoppingCart shoppingCart) {
        session.setAttribute("currentShoppingCart", shoppingCart);
    }

    public static User getCurrentUser(HttpSession session) {
        User currentUser = (User) session.getAttribute("current_user");
        return currentUser == null ? null : currentUser;
    }

    public static void setCurrentUser(HttpSession session, User user) {
        session.setAttribute("current_user", user);
    }

}
