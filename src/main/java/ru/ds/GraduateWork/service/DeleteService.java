package ru.ds.GraduateWork.service;

import org.springframework.stereotype.Service;

@Service
public interface DeleteService {
    void delete(long id, String uuid);
    boolean search(long id, String uuid);
    void save(long id, String uuid);
}
