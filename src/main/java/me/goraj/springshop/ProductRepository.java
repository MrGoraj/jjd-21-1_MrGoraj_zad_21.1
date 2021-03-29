package me.goraj.springshop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public final List<Product> productList = new ArrayList<>();

    public List<Product> getAll() {
        return productList;
    }

    public void add(Product product) {
        productList.add(product);
    }
}
