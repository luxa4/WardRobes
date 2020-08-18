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
import org.testng.annotations.Test;
import ru.belyaev.config.ApplicationConfig;
import ru.belyaev.service.ProductService;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationConfig.class})
public class SearchControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private SearchController searchController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
    }

    @Test
    public void controllerIsCreated() {
        Assert.assertNotNull(wac.getBean("searchController"));
    }

    @Test
    public void shouldReturnJsonObject() throws Exception {
        when(productService.countProductBySearchFilter(BigDecimal.valueOf(1),BigDecimal.valueOf(1),BigDecimal.valueOf(1),
                BigDecimal.valueOf(1),BigDecimal.valueOf(1),BigDecimal.valueOf(1),BigDecimal.valueOf(1),BigDecimal.valueOf(1))).thenReturn(1);

        MvcResult result = this.mockMvc.perform(get("/searchButtonCount")
                    .param("maxLen",String.valueOf(1))
                    .param("minLen",String.valueOf(1))
                    .param("maxHeight",String.valueOf(1))
                    .param("minHeight",String.valueOf(1))
                    .param("maxWidth",String.valueOf(1))
                    .param("minWidth",String.valueOf(1))
                    .param("maxPrice",String.valueOf(1))
                    .param("minPrice",String.valueOf(1))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("totalCount")))
                .andReturn();

        Assert.assertEquals("application/json", result.getResponse().getContentType());
    }

}