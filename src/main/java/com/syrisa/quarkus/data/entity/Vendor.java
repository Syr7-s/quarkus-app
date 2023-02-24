package com.syrisa.quarkus.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="vendors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vendor_id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="contact")
    private String contact;


    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;


    @Column(name="address")
    private String address;

}
