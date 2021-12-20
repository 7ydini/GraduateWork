package ru.ds.GraduateWork.repository.email;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ds.GraduateWork.model.entity.email.ApplicationConfirm;

@Repository
public interface ApplicationConfirmRepository extends JpaRepository<ApplicationConfirm, Long> {
    @Query("select applicationConfirm from ApplicationConfirm applicationConfirm where applicationConfirm.uuid like ?1")
    ApplicationConfirm getByUUID(String uuid);
}
