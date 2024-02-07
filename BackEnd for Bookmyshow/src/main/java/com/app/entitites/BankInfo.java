package com.app.entitites;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "bankinfo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_info_id")
    private int bankInfoId;

    @Column(name = "account_number", length = 20)
    private String accountNumber;

    @Column(name = "bank_name", length = 100)
    private String bankName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
