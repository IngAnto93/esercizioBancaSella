package com.bancasella.posillipo.antonio.esercizio.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.bancasella.posillipo.antonio.esercizio.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String>{

}
