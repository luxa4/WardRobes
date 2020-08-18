package ru.belyaev.controller.ajax;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.belyaev.config.ApplicationConfig;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.service.impl.ShoppingCartServiceImpl;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = {ApplicationConfig.class})
@WebAppConfiguration
public class AddToShoppingCartControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Mock
    private ShoppingCartServiceImpl shoppingCartService;

    @InjectMocks
    private AddToShoppingCartController addToShoppingCartController;

    @BeforeMethod
    public void setUp()  {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(addToShoppingCartController).build();
    }

    @Test
    public void shouldCreatControllerAddToShoppingCart() {
        Assert.assertNotNull(wac.getBean("addToShoppingCartController"));
    }

    @Test
    @Parameters({"productId", "count"})
    public void shouldReturnJsonObject(int productId, int count) throws Exception {
        when(shoppingCartService.addToShoppingCart(productId, count)).thenReturn(new ShoppingCart(1, BigDecimal.valueOf(1)));
        MvcResult result = this.mockMvc.perform(get("/addToShoppingCart")
                    .param("productId", String.valueOf(productId))
                    .param("count", String.valueOf(count))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("totalCount")))
                .andExpect(content().string(containsString("totalCost")))
                .andReturn();
        Assert.assertEquals("application/json", result.getResponse().getContentType());
    }
}