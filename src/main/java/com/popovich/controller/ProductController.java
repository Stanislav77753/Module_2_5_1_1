package com.popovich.controller;

import com.popovich.model.Product;
import com.popovich.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    private ProductService productService;

    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProducts(Model model){
        System.out.println("list");
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.getProducts());
        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product){
        System.out.println("add");
        if(product.getId() == null){
            System.out.println("add1");
            this.productService.addProduct(product);
        }else {
            System.out.println("add2");
            this.productService.updateProduct(product);
        }

        return "redirect:/products";
    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") Long id){
        this.productService.removeProduct(id);

        return "redirect:/products";
    }

    @RequestMapping("edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("products", this.productService.getProducts());

        return "products";
    }

    @RequestMapping("productdata/{id}")
    public String productData(@PathVariable("id") Long id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));

        return "productdata";
    }
}
