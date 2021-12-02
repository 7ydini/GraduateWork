package ru.ds.GraduateWork.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;
import ru.ds.GraduateWork.repository.service.ServiceBuyRepository;
import ru.ds.GraduateWork.repository.service.ServiceSaleRepository;
import ru.ds.GraduateWork.service.ServiceService;

@Data
@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceBuyRepository serviceBuyRepository;
    private final ServiceSaleRepository serviceSaleRepository;

    @Override
    public ServiceBuy addServiceBuy(ServiceBuy serviceBuy) {
        return null;
    }

    @Override
    public ServiceBuy getServiceBuy(long id) {
        return null;
    }

    @Override
    public ServiceSale addServiceSale(ServiceSale serviceSale) {
        return null;
    }

    @Override
    public ServiceSale getServiceSale(long id) {
        return null;
    }
}
