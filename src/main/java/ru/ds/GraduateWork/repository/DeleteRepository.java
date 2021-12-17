package ru.ds.GraduateWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.DeleteEntity;

@Repository
public interface DeleteRepository extends JpaRepository<DeleteEntity, Long> {
}
