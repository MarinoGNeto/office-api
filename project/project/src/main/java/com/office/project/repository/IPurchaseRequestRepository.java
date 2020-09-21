package com.office.project.repository;

import com.office.project.model.PurchaseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long> {
}
