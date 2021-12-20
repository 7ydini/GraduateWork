package ru.ds.GraduateWork.repository.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.email.DeleteEntity;

@Repository
public interface DeleteRepository extends JpaRepository<DeleteEntity, Long> {
}
