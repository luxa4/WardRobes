package ru.belyaev.controller.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.belyaev.entity.Product;
import ru.belyaev.model.JsonCart;
import ru.belyaev.service.ProductService;
import ru.belyaev.constant.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class SearchController {

    public static final Logger LOGGER = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    ProductService productService;

    @GetMapping("/search")
    public String showSearchResult(@RequestParam("minLen") BigDecimal minLen, @RequestParam("maxLen") BigDecimal maxLen,
                                 @RequestParam("minWidth") BigDecimal minWidth, @RequestParam("maxWidth") BigDecimal maxWidth,
                                 @RequestParam("minHeight") BigDecimal minHeight, @RequestParam("maxHeight") BigDecimal maxHeight,
                                 @RequestParam("minPrice") BigDecimal minPrice, @RequestParam("maxPrice") BigDecimal maxPrice,
                                 HttpServletRequest req) {

        List<Product> list = productService.productBySearchFilter(minLen, maxLen, minWidth, maxWidth, minHeight,
                                                                    maxHeight,minPrice, maxPrice);
        int count = productService.countProductBySearchFilter(minLen, maxLen, minWidth, maxWidth, minHeight,
                maxHeight,minPrice, maxPrice);

        req.setAttribute(SessionConstant.PRODUCT_LIST.toString(), list);
        req.setAttribute(SessionConstant.COUNT_PRODUCT_BY_SEARCH_FORM.toString(), count);
        return "fragments/product-list";
    }

    @GetMapping("/searchButtonCount")
    public @ResponseBody JsonCart showSearchCountResult(@RequestParam("minLen") BigDecimal minLen, @RequestParam("maxLen") BigDecimal maxLen,
                                   @RequestParam("minWidth") BigDecimal minWidth, @RequestParam("maxWidth") BigDecimal maxWidth,
                                   @RequestParam("minHeight") BigDecimal minHeight, @RequestParam("maxHeight") BigDecimal maxHeight,
                                   @RequestParam("minPrice") BigDecimal minPrice, @RequestParam("maxPrice") BigDecimal maxPrice,
                                   HttpServletRequest req) {


        int count = productService.countProductBySearchFilter(minLen, maxLen, minWidth, maxWidth, minHeight,
                maxHeight,minPrice, maxPrice);
        req.setAttribute(SessionConstant.COUNT_PRODUCT_BY_SEARCH_FORM.toString(), count);
        LOGGER.info("-->>> Вызван контроллер мгновенной фильтрации - {}", count);
        JsonCart jsonCart = new JsonCart();
        jsonCart.setTotalCount(count);
        return jsonCart;
    }


}
