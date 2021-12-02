package ru.ds.GraduateWork.service;

import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;
import ru.ds.GraduateWork.model.entity.product.ProductSale;

import java.util.List;

@Service
public interface ProductService {
    ProductBuy addProductBuy(ProductBuy productBuy);

    ProductBuy getProductBuyById(long id);

    ProductSale addProductSale(ProductSale productSale);

    ProductSale getProductSaleById(long id);

    List<ProductBuy> getAllProductBuy();

    List<ProductSale> getAllProductSale();
}
