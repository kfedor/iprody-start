package lesson44.example.controllers;

import org.example.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final CashierService cashierService;

    @Autowired
    public PaymentController(CashierService cashierService) {
        this.cashierService = cashierService;
    }

    @PostMapping("/payment")
    String pay() {
        return cashierService.pay();
    }
}
