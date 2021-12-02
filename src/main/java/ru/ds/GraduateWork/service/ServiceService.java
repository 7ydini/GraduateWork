package ru.ds.GraduateWork.service;

import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;

@Service
public interface ServiceService {
    ServiceBuy addServiceBuy(ServiceBuy serviceBuy);

    ServiceBuy getServiceBuy(long id);

    ServiceSale addServiceSale(ServiceSale serviceSale);

    ServiceSale getServiceSale(long id);
}
