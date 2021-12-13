package ru.ds.GraduateWork.model.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SERVICE_BUY")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "graduate_seq")
public class ServiceBuy {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;

    @NotNull(message = "Field can't be empty!")
    @Column(name = "price")
    private String price;

    @NotNull(message = "Field can't be empty!")
    @Size(min = 4, max = 64)
    @Column(name = "FULL_NAME")
    private String fullName;

    @NotNull(message = "Field can't be empty!")
    @Size(min = 4, max = 256, message = "Size 4 - 256")
    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull(message = "Field can't be empty!")
    @Email
    @Column(name = "MAIL")
    private String mail;

    @NotNull(message = "Field can't be empty!")
    @Column(name = "PHONE")
    private String phone;

    public ServiceBuy(String fullName, String price, String description, String mail, String phone) {
        this.price = price;
        this.fullName = fullName;
        this.description = description;
        this.mail = mail;
        this.phone = phone;
    }
}
