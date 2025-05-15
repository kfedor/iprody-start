package lesson44.example.service;

import java.util.Random;

public class EuroCashierService implements CashierService {

    @Override
    public String pay() {
        return new Random().nextInt(100) + " EURO";
    }
}
