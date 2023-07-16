package com.springcloud.CreditCardVerification.Repository;

import com.springcloud.CreditCardVerification.Entity.CreditCardVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardVerificationRepo extends JpaRepository<CreditCardVerification, Long> {
}
