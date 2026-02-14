package lesson46.test.java.org.example.repository;

import org.example.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;


    @Test
    void findById() {

        Order savedOrder = orderRepository.save(new Order(1L, "Test Order", "100", "USD"));
        Optional<Order> found = orderRepository.findById(savedOrder.getId());

        assertThat(found).isPresent();
        assertThat(found.get().getOrderName()).isEqualTo("Test Order");
        assertThat(found.get().getAmount()).isEqualTo("100");
        assertThat(found.get().getCurrency()).isEqualTo("USD");
    }

    @Test
    void findByOrderName() {
        orderRepository.save(new Order(1L, "Order A", "50", "EUR"));
        orderRepository.save(new Order(2L, "Order B", "30", "USD"));
        orderRepository.save(new Order(3L, "Order A", "70", "EUR"));

        List<Order> orders = orderRepository.findByOrderName("Order A");

        assertThat(orders).hasSize(2);
        assertThat(orders).allMatch(order -> order.getOrderName().equals("Order A"));
    }
}