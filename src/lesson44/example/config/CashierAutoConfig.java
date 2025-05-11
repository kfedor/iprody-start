package lesson44.example.config;

import org.example.service.CashierService;
import org.example.service.EuroCashierService;
import org.example.service.UsdCashierService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CashierAutoConfig {

    @ConditionalOnProperty(
            name = "app.currency",
            havingValue = "usd",
            matchIfMissing = true
    )
    @Bean
    public CashierService usdCashier() {
        return new UsdCashierService();
    }

    @ConditionalOnProperty(
            name = "app.currency",
            havingValue = "eur")
    @Bean
    public CashierService euroCashier() {
        return new EuroCashierService();
    }

}
