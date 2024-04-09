package com.example.testappforivan.app.repository;

import com.example.testappforivan.app.domain.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
}
