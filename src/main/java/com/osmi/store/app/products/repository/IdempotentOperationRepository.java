package com.osmi.store.app.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.osmi.store.app.products.entity.IdempotentOperation;

public interface IdempotentOperationRepository extends JpaRepository<IdempotentOperation, Long> {

	boolean existsByIdempotencyKey(String idempotencyKey);
	
}