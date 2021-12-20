package ru.ds.GraduateWork.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.product.ProductBuy;

@Repository
public interface ProductBuyRepository extends JpaRepository<ProductBuy, Long> {
    @Query("select productBuy.mail from ProductBuy productBuy where productBuy.id=?1")
    String getEmailById(@Param("id") long id);
}
