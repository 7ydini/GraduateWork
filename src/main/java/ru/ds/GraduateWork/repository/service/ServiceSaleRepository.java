package ru.ds.GraduateWork.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;

@Repository
public interface ServiceSaleRepository extends JpaRepository<ServiceSale, Long> {
    @Query("select ServiceSale.mail from ServiceSale where id=?1")
    String getEmailById(@Param("id") long id);
}
