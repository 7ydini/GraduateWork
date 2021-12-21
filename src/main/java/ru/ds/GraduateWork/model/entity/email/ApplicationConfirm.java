package ru.ds.GraduateWork.model.entity.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "application_confirm")
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "seq", sequenceName = "application_confirm_id_seq")
public class ApplicationConfirm {
    public ApplicationConfirm(String price, String fullName, String description, String mail, String phone, boolean product, boolean buy, String uuid) {
        this.price = price;
        this.fullName = fullName;
        this.description = description;
        this.mail = mail;
        this.phone = phone;
        this.product = product;
        this.buy = buy;
        this.uuid = uuid;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private long id;

    @NotNull(message = "Field can't be empty!")
    @Column(name = "price")
    private String price;

    @NotNull(message = "Field can't be empty!")
    @Size(min = 4, max = 64)
    @Column(name = "full_name")
    private String fullName;

    @NotNull(message = "Field can't be empty!")
    @Size(min = 4, max = 256, message = "Size 4 - 256")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Field can't be empty!")
    @Email
    @Column(name = "mail")
    private String mail;

    @NotNull(message = "Field can't be empty!")
    @Column(name = "phone")
    private String phone;

    @Column(name = "product")
    private boolean product;

    @Column(name = "buy")
    private boolean buy;

    @Column(name = "confirmed")
    private boolean confirmed;

    @Column(name = "uuid")
    private String uuid;

}
