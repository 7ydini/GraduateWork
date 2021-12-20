package ru.ds.GraduateWork.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.email.ApplicationConfirm;
import ru.ds.GraduateWork.model.entity.EntityPOJO;
import ru.ds.GraduateWork.repository.email.ApplicationConfirmRepository;
import ru.ds.GraduateWork.service.ApplicationConfirmService;

import java.util.Objects;

@Data
@Service
@AllArgsConstructor
public class ApplicationConfirmServiceImpl implements ApplicationConfirmService {
    private final ApplicationConfirmRepository repository;

    @Override
    public void save(EntityPOJO pojo, String uuid) {
        repository.saveAndFlush(new ApplicationConfirm(
                pojo.getPrice(),
                pojo.getFullName(),
                pojo.getDescription(),
                pojo.getMail(),
                pojo.getPhone(),
                pojo.isProduct(),
                pojo.isBuy(),
                uuid));
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean search(long id, String uuid) {
        if(Objects.equals(repository.getById(id).getUuid(), uuid)) {
            return true;
        }else return false;

    }
}
