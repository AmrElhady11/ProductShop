package com.amazon_El8alaba.controller;

import com.amazon_El8alaba.model.Product;
import com.amazon_El8alaba.model.ProductDetails;
import com.amazon_El8alaba.service.ProductService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/home")
    public String goToHomePage(Model model) {
        List<Product> productsList = productService.getAllProduct();
        model.addAttribute("productsList",productsList);

    return "HomePage";
    }
    @PostMapping("/showProductDetails")
    public String showProductDetails(@RequestParam int id,Model model){
       ProductDetails theProduct = productService.getProductDetails(id);
       model.addAttribute("productModel",theProduct);
        return "viewDetails";
    }
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result,@RequestParam int id){
        if(result.hasErrors()){
            return "viewDetails";
        }
        ProductDetails updatedProduct = productService.getProductDetails(id);
        updatedProduct.setName(theProduct.getName());
        updatedProduct.setExpirationDate(theProduct.getExpirationDate());
        productService.updateProduct(updatedProduct);
         return "redirect:/home";
    }
    @PostMapping("/addProduct")
    public String addProduct(Model model){
        model.addAttribute("productModel",new ProductDetails());
        return "addProduct";
    }

    @PostMapping("/processAddProduct")
    public String processAddProduct(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result){
        if(result.hasErrors()){
            return "addProduct";
        }
        productService.addProduct(theProduct);
        return "redirect:/home";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Model model){
        model.addAttribute("productModel",new ProductDetails());
        return "updateDetails";
    }

    @PostMapping("/processUpdateProductForm")
    public String processUpdateProductForm(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result){
        if(result.hasErrors()){
            return "updateDetails";
        }
        productService.updateProduct(theProduct);
        return "redirect:/home";
    }
    @PostMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return "redirect:/home";
    }
}
