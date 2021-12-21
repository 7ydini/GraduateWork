package ru.ds.GraduateWork.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ds.GraduateWork.model.entity.EntityPOJO;
import ru.ds.GraduateWork.model.entity.email.ApplicationConfirm;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;
import ru.ds.GraduateWork.model.entity.product.ProductSale;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;
import ru.ds.GraduateWork.service.EmailService;
import ru.ds.GraduateWork.service.Impl.ApplicationConfirmServiceImpl;
import ru.ds.GraduateWork.service.Impl.DeleteServiceImpl;
import ru.ds.GraduateWork.service.Impl.ProductServiceImpl;
import ru.ds.GraduateWork.service.Impl.ServiceServiceImpl;

import javax.validation.Valid;
import java.util.UUID;

@Data
@RequestMapping(value = "/shop")
@AllArgsConstructor
@org.springframework.stereotype.Controller
public class Controller {
    private final ProductServiceImpl productService;
    private final ServiceServiceImpl service;
    private final DeleteServiceImpl deleteService;
    private final EmailService emailService;
    private final ApplicationConfirmServiceImpl applicationConfirmService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("list", productService.getAllProductBuy());
        return "startpage";
    }


    /**
     * Products Applications
     **/
    @GetMapping(value = "/product/buy/")
    public String getAllProductBuy(Model model) {
        model.addAttribute("list", productService.getAllProductBuy());
        return "applications";
    }

    @GetMapping(value = "/product/sale/")
    public String getAllProductSale(Model model) {
        model.addAttribute("list", productService.getAllProductSale());
        return "applications";
    }

    @GetMapping(value = "/product/buy/{id}")
    public String getProductBuyById(@PathVariable("id") long id, Model model) {
        model.addAttribute("app", productService.getProductBuyById(id));
        System.out.println(productService.getProductBuyById(id));
        return "getById";
    }

    @GetMapping(value = "/product/sale/{id}")
    public String getProductSaleById(@PathVariable("id") long id, Model model) {
        model.addAttribute("app", productService.getProductSaleById(id));
        return "getById";
    }

    /**
     * Services Applications
     **/
    @GetMapping(value = "/service/buy/")
    public String getAllServiceBuy(Model model) {
        model.addAttribute("list", service.getAllServiceBuy());
        return "applications";
    }

    @GetMapping(value = "/service/sale/")
    public String getAllServiceSale(Model model) {
        model.addAttribute("list", service.getAllServiceSale());
        return "applications";
    }

    @GetMapping(value = "/service/buy/{id}")
    public String getServiceBuyById(@PathVariable("id") long id, Model model) {
        model.addAttribute("app", service.getServiceBuyById(id));
        return "getById";
    }

    @GetMapping(value = "/service/sale/{id}")
    public String getServiceSaleById(@PathVariable("id") long id, Model model) {
        model.addAttribute("app", service.getServiceSaleById(id));
        return "getById";
    }

    /**
     * Delete Application
     **/
    @PostMapping(value = "/product/buy/{id}/delete")
    public String getDeleteView(@PathVariable long id, Model model) {
        String uuid = java.util.UUID.randomUUID().toString();
        deleteService.save(id, uuid);
        emailService.sendSimpleEmail(productService.getBuyEmailById(id), "Confirm",
                "http://localhost:8080/shop/product/buy/" + id + "/delete/" + uuid);
        model.addAttribute("app", productService.getProductBuyById(id));
        model.addAttribute("confirm", "Check your email!");
        return "getById";
    }

    @GetMapping(value = "/product/buy/{id}/delete/{UUID}")
    public String deletePost(@PathVariable long id, @PathVariable("UUID") String uuid) {
        if (deleteService.search(id, uuid)) {
            productService.getProductBuyRepository().delete(productService.getProductBuyById(id));
            deleteService.delete(id, uuid);
            return "redirect:/shop/product/buy/";
        }
        return "redirect:/shop/product/buy/";
    }

    @PostMapping(value = "/product/sale/{id}/delete")
    public String getDeleteProductSaleView(@PathVariable long id, Model model) {
        String uuid = java.util.UUID.randomUUID().toString();
        deleteService.save(id, uuid);
        emailService.sendSimpleEmail(productService.getSaleEmailById(id), "Confirm",
                "http://localhost:8080/shop/product/sale/" + id + "/delete/" + uuid);
        model.addAttribute("confirm", "Check your email!");
        model.addAttribute("app", productService.getProductSaleById(id));
        return "getById";
    }

    @GetMapping(value = "/product/sale/{id}/delete/{UUID}")
    public String deleteSalePost(@PathVariable long id, @PathVariable("UUID") String uuid) {
        if (deleteService.search(id, uuid)) {
            productService.getProductSaleRepository().delete(productService.getProductSaleById(id));
            deleteService.delete(id, uuid);
            return "redirect:/shop/product/sale/";
        }
        return "redirect:/shop/product/sale/";
    }


    @PostMapping(value = "/service/buy/{id}/delete")
    public String getServiceBuyDeleteView(@PathVariable long id, Model model) {
        String uuid = java.util.UUID.randomUUID().toString();
        deleteService.save(id, uuid);
        emailService.sendSimpleEmail(service.getBuyEmailById(id), "Confirm",
                "http://localhost:8080/shop/service/buy/" + id + "/delete/" + uuid);
        model.addAttribute("app", service.getServiceBuyById(id));
        model.addAttribute("confirm", "Check your email!");
        return "getById";
    }

    @GetMapping(value = "/service/buy/{id}/delete/{UUID}")
    public String deleteServiceBuyPost(@PathVariable long id, @PathVariable("UUID") String uuid) {
        if (deleteService.search(id, uuid)) {
            service.getServiceBuyRepository().delete(service.getServiceBuyById(id));
            deleteService.delete(id, uuid);
            return "redirect:/shop/service/buy/";
        }
        return "redirect:/shop/service/buy/";
    }

    @PostMapping(value = "/service/sale/{id}/delete")
    public String getDeleteSaleView(@PathVariable long id, Model model) {
        String uuid = java.util.UUID.randomUUID().toString();
        deleteService.save(id, uuid);
        emailService.sendSimpleEmail(service.getSaleEmailById(id), "Confirm",
                "http://localhost:8080/shop/service/sale/" + id + "/delete/" + uuid);
        model.addAttribute("app", service.getServiceSaleById(id));
        model.addAttribute("confirm", "Check your email!");
        return "getById";
    }

    @GetMapping(value = "/service/sale/{id}/delete/{UUID}")
    public String deleteServiceSalePost(@PathVariable long id, @PathVariable("UUID") String uuid) {
        if (deleteService.search(id, uuid)) {
            service.getServiceSaleRepository().delete(service.getServiceSaleById(id));
            deleteService.delete(id, uuid);
            return "redirect:/shop/service/sale/";
        }
        return "redirect:/shop/service/sale/";
    }
    //


    /**
     * Create new Application
     **/
    @GetMapping("/create")
    public String createView(Model model) {
        model.addAttribute("pojo", new EntityPOJO());
        return "create";
    }

    @PostMapping("/create")
    public String createAd(@ModelAttribute("pojo") @Valid EntityPOJO pojo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pojo", pojo);
            if (result.hasFieldErrors("fullName")) {
                model.addAttribute("fullNameError", "Input correct value!");
            }
            if (result.hasFieldErrors("price")) {
                model.addAttribute("priceError", "Input correct value!");
            }
            if (result.hasFieldErrors("description")) {
                model.addAttribute("descriptionError", "Input correct value!");
            }
            if (result.hasFieldErrors("mail")) {
                model.addAttribute("mailError", "Input correct value!");
            }
            if (result.hasFieldErrors("phone")) {
                model.addAttribute("phoneError", "Input correct value!");
            }
            return "create";
        }
        model.addAttribute("confirm", "Check your email!");
        String uuid = UUID.randomUUID().toString();
        applicationConfirmService.save(pojo, uuid);
        emailService.sendSimpleEmail(pojo.getMail(), "Confirm create application",
                "http://localhost:8080/shop/create/" + uuid);
        return "create";
    }

    @GetMapping(value = "/create/{UUID}")
    public String ConfirmCreate(@PathVariable("UUID") String uuid) {
        ApplicationConfirm pojo = applicationConfirmService.getRepository().getByUUID(uuid);
        if (pojo.isProduct()) {
            if (pojo.isBuy()) {
                productService.addProductBuy(new ProductBuy(
                        pojo.getFullName(),
                        pojo.getPrice(),
                        pojo.getDescription(),
                        pojo.getMail(),
                        pojo.getPhone()));

            } else productService.addProductSale(new ProductSale(
                    pojo.getFullName(),
                    pojo.getPrice(),
                    pojo.getDescription(),
                    pojo.getMail(),
                    pojo.getPhone()));

        } else if (pojo.isBuy()) {
            service.addServiceBuy(new ServiceBuy(
                    pojo.getFullName(),
                    pojo.getPrice(),
                    pojo.getDescription(),
                    pojo.getMail(),
                    pojo.getPhone()));

        } else service.addServiceSale(new ServiceSale(
                pojo.getFullName(),
                pojo.getPrice(),
                pojo.getDescription(),
                pojo.getMail(),
                pojo.getPhone()));
        applicationConfirmService.delete(pojo.getId());
        return "redirect:/shop";
    }

    /**
     * Redirects
     **/
    @PostMapping(value = "/product/buy/btn")
    public String ProductBuyBtn() {
        return "redirect:/shop/product/buy";
    }

    @PostMapping(value = "/product/sale/btn")
    public String ProductSaleBtn() {
        return "redirect:/shop/product/sale";
    }

    @PostMapping(value = "/service/buy/btn")
    public String ServiceBuyBtn() {
        return "redirect:/shop/service/buy";
    }

    @PostMapping(value = "/service/sale/btn")
    public String ServiceSaleBtn() {
        return "redirect:/shop/service/sale";
    }

    @GetMapping(value = "/product/sale")
    public String getAllProductSaleRed() {
        return "redirect:/shop/product/sale/";
    }

    @GetMapping(value = "/product/buy")
    public String getAllProductBuyRed() {
        return "redirect:/shop/product/buy/";
    }

    @GetMapping(value = "/service/sale")
    public String getAllServiceSaleRed() {
        return "redirect:/shop/service/sale/";
    }

    @GetMapping(value = "/service/buy")
    public String getAllServiceBuyRed() {
        return "redirect:/shop/service/buy/";
    }

    //Test
    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

}
