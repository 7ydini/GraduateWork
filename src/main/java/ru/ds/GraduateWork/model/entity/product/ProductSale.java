package ru.ds.GraduateWork.model.entity.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "PRODUCT_SALE")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "graduate_seq")
public class ProductSale {
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

    public ProductSale(String fullName, String description, String mail, String phone) {
        this.fullName = fullName;
        this.description = description;
        this.mail = mail;
        this.phone = phone;
    }
}
