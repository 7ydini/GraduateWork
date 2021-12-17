package ru.ds.GraduateWork.service;

import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;

import java.util.List;

@Service
public interface ServiceService {

    List<ServiceBuy> getAllServiceBuy();

    List<ServiceSale> getAllServiceSale();

    ServiceBuy addServiceBuy(ServiceBuy serviceBuy);

    ServiceBuy getServiceBuyById(long id);

    ServiceSale addServiceSale(ServiceSale serviceSale);

    ServiceSale getServiceSaleById(long id);
    String getBuyEmailById(long id);
    String getSaleEmailById(long id);
}
