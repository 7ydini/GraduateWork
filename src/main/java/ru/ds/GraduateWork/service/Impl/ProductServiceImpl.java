package ru.ds.GraduateWork.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;
import ru.ds.GraduateWork.model.entity.product.ProductSale;
import ru.ds.GraduateWork.repository.product.ProductBuyRepository;
import ru.ds.GraduateWork.repository.product.ProductSaleRepository;
import ru.ds.GraduateWork.service.ProductService;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductBuyRepository productBuyRepository;
    private final ProductSaleRepository productSaleRepository;

    @Override
    public ProductBuy addProductBuy(ProductBuy productBuy) {
        return productBuyRepository.saveAndFlush(productBuy);
    }

    @Override
    public ProductBuy getProductBuyById(long id) {
        return productBuyRepository.getById(id);
    }

    @Override
    public ProductSale addProductSale(ProductSale productSale) {
        return productSaleRepository.saveAndFlush(productSale);
    }

    @Override
    public ProductSale getProductSaleById(long id) {
        return productSaleRepository.getById(id);
    }

    @Override
    public List<ProductBuy> getAllProductBuy() {
        return productBuyRepository.findAll();
    }

    @Override
    public List<ProductSale> getAllProductSale() {
        return productSaleRepository.findAll();
    }

    @Override
    public String getBuyEmailById(long id) {
        return productBuyRepository.getEmailById(id);
    }
    @Override
    public String getSaleEmailById(long id) {
        return productSaleRepository.getEmailById(id);
    }
}
