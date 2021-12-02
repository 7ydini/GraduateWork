package ru.ds.GraduateWork.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;

@Repository
public interface ProductBuyRepository extends JpaRepository<ProductBuy, Long> {
}
