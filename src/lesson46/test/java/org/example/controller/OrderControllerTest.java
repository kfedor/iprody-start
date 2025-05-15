package lesson46.test.java.org.example.controller;

import org.example.entity.Order;
import org.example.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void testGetById() throws Exception {
        Order order = new Order(1L, "Test Order", "100", "USD");
        Mockito.when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        mockMvc.perform(get("/orders/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.orderName").value("Test Order"))
                .andExpect(jsonPath("$.amount").value("100"))
                .andExpect(jsonPath("$.currency").value("USD"));
    }

    @Test
    void testGetByName() throws Exception {
        List<Order> orders = List.of(
                new Order(1L, "Order A", "50", "EUR"),
                new Order(2L, "Order A", "70", "EUR")
        );

        Mockito.when(orderRepository.findByOrderName(eq("Order A"))).thenReturn(orders);

        mockMvc.perform(get("/orders/search")
                        .param("name", "Order A"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].orderName").value("Order A"))
                .andExpect(jsonPath("$[1].orderName").value("Order A"));
    }
}
