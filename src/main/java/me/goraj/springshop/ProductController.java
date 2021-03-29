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
        if (checkNotEmpty(formProduct)) {
            model.addAttribute("formProduct", formProduct);
            return "success";
        } else {
            return "redirect:sorry";
        }
    }

    @GetMapping("/sorry")
    public String error() {
        return "sorry";
    }

    private boolean checkNotEmpty(Product product) {
        return (product.getName() != null && product.getName().length() > 0
                && product.getPrice() > 0
                && product.getCategory() != null);
    }

    @ResponseBody
    @RequestMapping("/list")
    public String list() {
        List<Product> productList = productRepository.getAll();
        StringBuilder result = new StringBuilder();
        for (Product product : productList) {
            result.append(product);
        }
        return result.toString();
    }
}
