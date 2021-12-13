package ru.ds.GraduateWork.model.entity;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntityPOJO {

    private boolean Product;

    private boolean buy;

    @NotNull
    private String price;

    @NotNull
    @Size(min = 4, max = 64)
    private String fullName;

    @NotNull
    @Size(min = 4, max = 256)
    private String description;

    @Email
    @NotNull
    private String mail;

    @NotNull
    private String phone;
}
