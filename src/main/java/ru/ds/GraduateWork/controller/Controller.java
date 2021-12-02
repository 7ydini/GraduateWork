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

@Data
@RequestMapping(value = "/shop")
@AllArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {
    private final ProductServiceImpl productService;
    private final ServiceServiceImpl service;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("list", productService.getAllProductBuy());
        return "startpage";
    }

    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("pojo", new EntityPOJO());
        return "create";
    }


    //Product
    @GetMapping(value = "/product/buy")
    public String getAllProductBuy(Model model) {
        model.addAttribute("list", productService.getAllProductBuy());
        return "startpage";
    }

    @GetMapping(value = "/product/sale")
    public String getAllProductSale(Model model) {
        model.addAttribute("list", productService.getAllProductSale());
        return "startpage";
    }

    @GetMapping(value = "/product/buy/{id}")
    public String getProductBuyById(@PathVariable("id") long id, Model model) {
        model.addAttribute("list", productService.getProductBuyById(id));
        return "getById";
    }

    @GetMapping(value = "/product/sale/{id}")
    public String getProductSaleById(@PathVariable("id") long id, Model model) {
        model.addAttribute("list", productService.getProductSaleById(id));
        return "getById";
    }

    //Service
    @GetMapping(value = "/service/buy")
    public String getAllServiceBuy(Model model) {
        model.addAttribute("list", service.getAllServiceBuy());
        return "startpage";
    }

    @GetMapping(value = "/service/sale")
    public String getAllServiceSale(Model model) {
        model.addAttribute(service.getAllServiceSale());
        return "startpage";
    }

    @GetMapping(value = "/service/buy/{id}")
    public String getServiceBuyById(@PathVariable("id") long id, Model model) {
        model.addAttribute(service.getServiceBuyById(id));
        return "getById";
    }

    @GetMapping(value = "/service/sale/{id}")
    public String getServiceSaleById(@PathVariable("id") long id, Model model) {
        model.addAttribute("list", service.getServiceSaleById(id));
        return "getById";
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
    //redirects
    @PostMapping(value = "/product/buy")
    public String ProductBuyBtn(){
        return "redirect:/shop/product/buy";
    }
    @PostMapping(value = "/product/sale")
    public String ProductSaleBtn(){
        return "redirect:/shop/product/sale";
    }
    @PostMapping(value = "/service/buy")
    public String ServiceBuyBtn(){
        return "redirect:/shop/service/buy";
    }
    @PostMapping(value = "/product/buy")
    public String ServiceSaleBtn(){
        return "redirect:/shop/service/sale";
    }

}
