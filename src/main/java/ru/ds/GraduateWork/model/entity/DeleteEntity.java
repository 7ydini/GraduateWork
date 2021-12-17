package ru.ds.GraduateWork.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "delete")
@NoArgsConstructor
@AllArgsConstructor
public class DeleteEntity {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "uuid")
    private String uuid;
}
