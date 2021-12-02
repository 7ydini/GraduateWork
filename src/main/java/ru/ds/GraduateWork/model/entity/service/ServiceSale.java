package ru.ds.GraduateWork.model.entity.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "SERVICE_SALE")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "graduate_seq")
public class ServiceSale {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "PHONE")
    private String phone;

}
