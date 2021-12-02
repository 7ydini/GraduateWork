package ru.ds.GraduateWork.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ds.GraduateWork.model.entity.EntityPOJO;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;
import ru.ds.GraduateWork.model.entity.product.ProductSale;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;
import ru.ds.GraduateWork.service.Impl.ProductServiceImpl;
import ru.ds.GraduateWork.service.Impl.ServiceServiceImpl;

import java.util.List;

@Data
@RequestMapping(value = "/shop")
@AllArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {
    private final ProductServiceImpl productService;
    private final ServiceServiceImpl service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("productList", productService.getAllProductBuy());
        return "startpage";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("pojo", new EntityPOJO());
        return "create";
    }


    //Product
    @GetMapping(value = "/product/buy")
    public List<ProductBuy> getAllProductBuy() {
        return productService.getAllProductBuy();
    }

    @GetMapping(value = "/product/sale")
    public List<ProductSale> getAllProductSale() {
        return productService.getAllProductSale();
    }

    @GetMapping(value = "/product/buy/{id}")
    public ProductBuy getProductBuyById(@PathVariable("id") long id) {
        return productService.getProductBuyById(id);
    }

    @GetMapping(value = "/product/sale/{id}")
    public ProductSale getProductSaleById(@PathVariable("id") long id) {
        return productService.getProductSaleById(id);
    }

    //Service
    @GetMapping(value = "/service/buy")
    public List<ServiceBuy> getAllServiceBuy() {
        return service.getAllServiceBuy();
    }

    @GetMapping(value = "/service/sale")
    public List<ServiceSale> getAllServiceSale() {
        return service.getAllServiceSale();
    }

    @GetMapping(value = "/service/buy/{id}")
    public ServiceBuy getServiceBuyById(@PathVariable("id") long id) {
        return service.getServiceBuyById(id);
    }

    @GetMapping(value = "/service/sale/{id}")
    public ServiceSale getServiceSaleById(@PathVariable("id") long id) {
        return service.getServiceSaleById(id);
    }

    @PostMapping("/create")
    public String createAd(@ModelAttribute EntityPOJO pojo) {
        if (pojo.isProduct()) {
            if (pojo.isBuy()) {
                productService.addProductBuy(
                        new ProductBuy(pojo.getFullName(), pojo.getDescription(), pojo.getMail(), pojo.getPhone()));
            } else productService.addProductSale(
                    new ProductSale(pojo.getFullName(), pojo.getDescription(), pojo.getMail(), pojo.getPhone()));
        } else if (pojo.isBuy()) {
            service.addServiceBuy(
                    new ServiceBuy(pojo.getFullName(), pojo.getDescription(), pojo.getMail(), pojo.getPhone()));
        } else service.addServiceSale(
                new ServiceSale(pojo.getFullName(), pojo.getDescription(), pojo.getMail(), pojo.getPhone()));
        return "redirect:/shop";
    }

}
