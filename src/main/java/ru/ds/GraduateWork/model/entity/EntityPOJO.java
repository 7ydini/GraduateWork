package ru.ds.GraduateWork.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityPOJO {

    private boolean Product;

    private boolean buy;

    private String price;

    private String fullName;

    private String description;

    private String mail;

    private String phone;
}
