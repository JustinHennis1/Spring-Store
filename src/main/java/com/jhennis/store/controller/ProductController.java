package com.jhennis.store.controller;

import com.jhennis.store.model.Product;
import com.jhennis.store.model.User;
import com.jhennis.store.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    private final ProductRepo productRepository;

    @Autowired
    public ProductController(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Product> products = productRepository.findAll();

        model.addAttribute("products", products);
        return "index";
    }

    @PostMapping("/products/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);

    }

    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        // Verify the product exists first
        Product existingProduct = productRepository.findById(product.getProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        // Update the existing product's fields
        existingProduct.setTitle(product.getTitle());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());

        // Save the updated product
        productRepository.save(existingProduct);

        redirectAttributes.addFlashAttribute("message", "Product updated successfully!");
        return "redirect:/";
    }

    @DeleteMapping("/products/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }

    @GetMapping("/products/{id}")
    public String showProductDetails(@PathVariable("id") int productId, Model model) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        model.addAttribute("product", product);
        return "product-details"; // Create this template for product details page
    }
}
