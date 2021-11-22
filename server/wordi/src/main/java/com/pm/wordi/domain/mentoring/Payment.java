package com.pm.wordi.domain.mentoring;

import com.pm.wordi.domain.BaseStatus;
import com.pm.wordi.domain.BaseTimeEntity;
import com.pm.wordi.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    private String orderNumber;

    private Long price;

    private String depositor;

    private String bankCode;

    private String accountNumber;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Enumerated(EnumType.STRING)
    private BaseStatus status;

    @Builder
    public Payment(User user, String orderNumber, Long price, String depositor, String bankCode,
                   String accountNumber, PaymentStatus paymentStatus, BaseStatus status) {
        this.user = user;
        this.orderNumber = orderNumber;
        this.price = price;
        this.depositor = depositor;
        this.bankCode = bankCode;
        this.accountNumber = accountNumber;
        this.paymentStatus = paymentStatus;
        this.status = status;
    }
}
