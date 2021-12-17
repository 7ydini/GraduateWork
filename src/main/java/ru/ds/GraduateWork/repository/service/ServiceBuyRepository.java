package ru.ds.GraduateWork.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;

@Repository
public interface ServiceBuyRepository extends JpaRepository<ServiceBuy, Long> {
    @Query("select ServiceBuy .mail from ServiceBuy where id=?1")
    String getEmailById(@Param("id") long id);
}
