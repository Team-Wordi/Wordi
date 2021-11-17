package com.pm.wordi.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String orderNumber;

    private Long price;

    private String depositor;

    private String bankCode;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


}
