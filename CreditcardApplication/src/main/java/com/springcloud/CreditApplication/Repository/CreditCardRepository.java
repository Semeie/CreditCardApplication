package com.springcloud.CreditApplication.Repository;

import com.springcloud.CreditApplication.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findByPublishStatus(boolean isPublished);
}
