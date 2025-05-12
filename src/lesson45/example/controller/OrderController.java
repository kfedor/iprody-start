package lesson45.example.controller;

import org.example.entity.Order;
import org.example.repository.OrderRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Optional<Order> getById(@PathVariable(name = "id") Long id) {
        return repository.findById(id);
    }

    @GetMapping("/search")
    public Optional<Order> getByName(@RequestParam String name) {
        return repository.findByOrderName(name);
    }
}
