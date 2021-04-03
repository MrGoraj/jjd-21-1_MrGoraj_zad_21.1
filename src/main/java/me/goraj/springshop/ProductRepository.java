package me.goraj.springshop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public final List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public boolean checkNotEmpty(Product product) {
        return (product.getName() != null && product.getName().length() > 0
                && product.getPrice() > 0
                && product.getCategory() != null);
    }
}
