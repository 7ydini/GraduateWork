package ru.ds.GraduateWork.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.product.ProductSale;

@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSale, Long> {

}
