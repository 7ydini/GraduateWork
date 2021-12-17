package ru.ds.GraduateWork.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.service.ServiceBuy;
import ru.ds.GraduateWork.model.entity.service.ServiceSale;
import ru.ds.GraduateWork.repository.service.ServiceBuyRepository;
import ru.ds.GraduateWork.repository.service.ServiceSaleRepository;
import ru.ds.GraduateWork.service.ServiceService;

import java.util.List;

@Data
@Service
@AllArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceBuyRepository serviceBuyRepository;
    private final ServiceSaleRepository serviceSaleRepository;

    @Override
    public List<ServiceBuy> getAllServiceBuy() {
        return serviceBuyRepository.findAll();
    }

    @Override
    public List<ServiceSale> getAllServiceSale() {
        return serviceSaleRepository.findAll();
    }

    @Override
    public ServiceBuy addServiceBuy(ServiceBuy serviceBuy) {
        return serviceBuyRepository.saveAndFlush(serviceBuy);
    }

    @Override
    public ServiceBuy getServiceBuyById(long id) {
        return serviceBuyRepository.getById(id);
    }

    @Override
    public ServiceSale addServiceSale(ServiceSale serviceSale) {
        return serviceSaleRepository.saveAndFlush(serviceSale);
    }

    @Override
    public ServiceSale getServiceSaleById(long id) {
        return serviceSaleRepository.getById(id);
    }

    @Override
    public String getBuyEmailById(long id) {
        return serviceBuyRepository.getEmailById(id);
    }
    @Override
    public String getSaleEmailById(long id) {
        return serviceSaleRepository.getEmailById(id);
    }
}
