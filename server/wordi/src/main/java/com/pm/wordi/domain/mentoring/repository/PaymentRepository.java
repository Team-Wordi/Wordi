package com.pm.wordi.domain.mentoring.repository;

import com.pm.wordi.domain.mentoring.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
