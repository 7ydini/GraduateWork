package ru.ds.GraduateWork.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityPOJO {

    //private RadioBattonSelect radio;

    private boolean Product;

    private boolean buy;

    private String fullName;

    private String description;

    private String mail;

    private String phone;
}
