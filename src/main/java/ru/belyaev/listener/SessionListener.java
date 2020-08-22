package ru.belyaev.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import ru.belyaev.service.ProductService;
import ru.belyaev.constant.SessionConstant;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.math.BigDecimal;

@Component
public class SessionListener implements HttpSessionListener, ApplicationContextAware {

    @Autowired
    private ProductService productService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ((WebApplicationContext) applicationContext).getServletContext().addListener(this);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Long countProduct   = productService.countAllProduct();
        BigDecimal maxLen   = productService.showMaxLength();
        BigDecimal minLen   = productService.showMinLength();
        BigDecimal maxHei   = productService.showMaxHeight();
        BigDecimal minHei   = productService.showMinHeight();
        BigDecimal maxWid   = productService.showMaxWidth();
        BigDecimal minWid   = productService.showMinWidth();
        BigDecimal maxPrice = productService.showMaxPrice();
        BigDecimal minPrice = productService.showMinPrice();

        se.getSession().setAttribute(SessionConstant.MAX_LEN.toString(), maxLen.toPlainString());
        se.getSession().setAttribute(SessionConstant.MIN_LEN.toString(), minLen.toPlainString());
        se.getSession().setAttribute(SessionConstant.MAX_HEI.toString(), maxHei.toPlainString());
        se.getSession().setAttribute(SessionConstant.MIN_HEI.toString(), minHei.toPlainString());
        se.getSession().setAttribute(SessionConstant.MAX_WID.toString(), maxWid.toPlainString());
        se.getSession().setAttribute(SessionConstant.MIN_WID.toString(), minWid.toPlainString());
        se.getSession().setAttribute(SessionConstant.MAX_PRICE.toString(), maxPrice.toPlainString());
        se.getSession().setAttribute(SessionConstant.MIN_PRICE.toString(), minPrice.toPlainString());
        se.getSession().setAttribute(SessionConstant.COUNT_PRODUCT.toString(), countProduct);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
