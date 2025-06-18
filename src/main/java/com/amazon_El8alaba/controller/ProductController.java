package com.amazon_El8alaba.controller;

import com.amazon_El8alaba.enums.Role;
import com.amazon_El8alaba.model.Product;
import com.amazon_El8alaba.model.ProductDetails;
import com.amazon_El8alaba.model.User;
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
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping("/home")
    public String goToHomePage(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        if(currentUser==null)
            return "redirect:/login";
        if(currentUser.getRole()!= Role.ADMIN)
            return "ErrorManagement/NotAllowed";
        System.out.println("========================================"+ currentUser.getEmail());
        List<Product> productsList = productService.getAllProduct();
        model.addAttribute("productsList",productsList);

    return "ProjectManagement/HomePage";
    }
    @PostMapping("/showProductDetails")
    public String showProductDetails(@RequestParam int id,Model model){
       ProductDetails theProduct = productService.getProductDetails(id);
       model.addAttribute("productModel",theProduct);
        return "ProjectManagement/viewDetails";
    }
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result,@RequestParam int id){
        if(result.hasErrors()){
            return "ProjectManagement/viewDetails";
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
        return "ProjectManagement/addProduct";
    }

    @PostMapping("/processAddProduct")
    public String processAddProduct(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result){
        if(result.hasErrors()){
            return "ProjectManagement/addProduct";
        }
        productService.addProduct(theProduct);
        return "redirect:/home";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(Model model){
        model.addAttribute("productModel",new ProductDetails());
        return "ProjectManagement/updateDetails";
    }

    @PostMapping("/processUpdateProductForm")
    public String processUpdateProductForm(@Valid @ModelAttribute("productModel") ProductDetails theProduct , BindingResult result){
        if(result.hasErrors()){
            return "ProjectManagement/updateDetails";
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
