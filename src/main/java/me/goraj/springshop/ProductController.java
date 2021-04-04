package me.goraj.springshop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product formProduct, Model model) {
        if (productRepository.checkNotEmpty(formProduct)) {
            model.addAttribute("formProduct", formProduct);
            return "success";
        } else {
            return "sorry";
        }
    }

    @GetMapping("/sorry")
    public String error() {
        return "sorry";
    }

    @RequestMapping("/lista")
    public String lista(Model model) {
        List<Product> productList = productRepository.getAll();
        model.addAttribute("productList", productList);
        double sum = 0;
        for (Product product : productList) {
            sum += product.getPrice();
        }
        return "list";
    }
}
