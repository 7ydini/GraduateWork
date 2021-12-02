package ru.ds.GraduateWork.service;

import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;
import ru.ds.GraduateWork.model.entity.product.ProductSale;

@Service
public interface ProductService {
    ProductBuy addProductBuy(ProductBuy productBuy);

    ProductBuy getProductBuy(long id);

    ProductSale addProductSale(ProductSale productSale);

    ProductSale getProductSale(long id);
}
