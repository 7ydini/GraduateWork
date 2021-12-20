package ru.ds.GraduateWork.service.Impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.ds.GraduateWork.model.entity.email.DeleteEntity;
import ru.ds.GraduateWork.repository.email.DeleteRepository;
import ru.ds.GraduateWork.service.DeleteService;

import java.util.Objects;

@Data
@Service
@AllArgsConstructor
public class DeleteServiceImpl implements DeleteService {

    private final DeleteRepository deleteRepository;

    public void save(long id, String uuid) {
        deleteRepository.saveAndFlush(new DeleteEntity(id, uuid));
    }

    @Override
    public void delete(long id, String uuid) {
        deleteRepository.delete(new DeleteEntity(id, uuid));
    }

    @Override
    public boolean search(long id, String uuid) {
        if(Objects.equals(deleteRepository.getById(id).getUuid(), uuid)) {
            return true;
        }else return false;

    }

}
