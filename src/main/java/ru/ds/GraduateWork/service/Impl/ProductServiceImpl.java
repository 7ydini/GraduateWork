package ru.ds.GraduateWork.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;
import ru.ds.GraduateWork.model.entity.product.ProductSale;
import ru.ds.GraduateWork.repository.product.ProductBuyRepository;
import ru.ds.GraduateWork.repository.product.ProductSaleRepository;
import ru.ds.GraduateWork.service.ProductService;

@Data
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductBuyRepository productBuyRepository;
    private final ProductSaleRepository productSaleRepository;

    @Override
    public ProductBuy addProductBuy(ProductBuy productBuy) {
        return null;
    }

    @Override
    public ProductBuy getProductBuy(long id) {
        return null;
    }

    @Override
    public ProductSale addProductSale(ProductSale productSale) {
        return null;
    }

    @Override
    public ProductSale getProductSale(long id) {
        return null;
    }
}
