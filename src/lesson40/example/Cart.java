package lesson40.example;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Component("cart")
@Scope("prototype")
public class Cart {

    @Autowired
    private ProductRepository productRepository;

    private List<Product> productsInCart;

    public Cart(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProductById(Integer id) {
        setProductsInCart(new ArrayList<>());
        productsInCart.add(productRepository.getProductById(id));
    }
}
