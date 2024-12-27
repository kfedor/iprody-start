package lesson15.cofeeshop;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CoffeeOrderBoard {

    private final List<Order> orderList = new LinkedList<>();
    private int orderCounter = 1;

    /**
     * Method adds new order to list.
     *
     * @param name of person who made an order
     */
    public void add(String name) {
        orderList.add(new Order(name, orderCounter++));
    }

    /**
     * Method returns the order closest to the queue and then removes the order from the list.
     *
     * @return order from the head of the list
     */
    public Order deliver() {
        return orderList.removeFirst();
    }

    /**
     * Method returns the order under defined number and then removes the order from the list.
     *
     * @param number of the order to deliver
     * @return order under defined number
     */
    public Optional<Order> deliver(Integer number) {
        for (Order order : orderList) {
            if (number.equals(order.number())) {
                return Optional.of(orderList.remove(orderList.indexOf(order)));
            }
        }
        return Optional.empty();
    }

    /**
     * Method prints the state of order list.
     */
    public void draw() {
        System.out.println(orderList);
    }

    @Override
    public String toString() {
        return orderList.toString();
    }
}
