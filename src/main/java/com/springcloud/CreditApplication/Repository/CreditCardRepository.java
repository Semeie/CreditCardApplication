package com.springcloud.CreditApplication.Repository;

import com.springcloud.CreditApplication.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
