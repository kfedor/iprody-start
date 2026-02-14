package lesson46.example.repository;

import org.example.entity.Order;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends Repository<Order, Long> {

    Optional<Order> findById(Long id);

    List<Order> findByOrderName(String orderName);

    Iterable<Order> findAll();

    Order save(Order order);

    void deleteById(Long id);


}
