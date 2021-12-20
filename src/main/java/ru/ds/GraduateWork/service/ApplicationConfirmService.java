package ru.ds.GraduateWork.service;

import ru.ds.GraduateWork.model.entity.EntityPOJO;

public interface ApplicationConfirmService {
    public void save(EntityPOJO pojo, String uuid);
    public void delete(long id);
    public boolean search(long id, String uuid);
}
