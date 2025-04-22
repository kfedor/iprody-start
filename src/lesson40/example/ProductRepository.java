package lesson40.example;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("productRepository")
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    public void init() {
        setProducts(new ArrayList<>());
        Product product1 = new Product(1, "product1", 1.0);
        Product product2 = new Product(2, "product2", 2.0);
        Product product3 = new Product(3, "product3", 3.0);
        Product product4 = new Product(4, "product4", 4.0);
        Product product5 = new Product(5, "product5", 5.0);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Integer productId) {
        for (Product product : products) {
            if (product.getId().equals(productId)) {
                return product;
            }
        }
        throw new IllegalArgumentException("There is no product with defined id.");
    }


}
