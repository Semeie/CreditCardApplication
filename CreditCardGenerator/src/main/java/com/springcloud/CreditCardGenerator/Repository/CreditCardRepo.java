package com.springcloud.CreditCardGenerator.Repository;

import com.springcloud.CreditCardGenerator.Entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepo extends JpaRepository<CreditCard, Long>{
    CreditCard findByRefId(String applicationRefId);
}
