package ru.ds.GraduateWork.repository.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;

@Repository
public interface ServiceBuyRepository extends JpaRepository<ServiceBuy, Long> {
}
