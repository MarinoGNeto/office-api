package com.office.project.service;

import com.office.project.dto.PurchaseRequestDTO;
import com.office.project.enums.StatusPurchaseRequest;
import com.office.project.model.PurchaseRequest;
import com.office.project.repository.IPurchaseRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseRequestService.class);

    private final IPurchaseRequestRepository purchaseRequestRepository;

    public PurchaseRequestService(IPurchaseRequestRepository purchaseRequestRepository) {
        this.purchaseRequestRepository = purchaseRequestRepository;
    }

    public PurchaseRequestDTO save(PurchaseRequestDTO purchaseRequestDTO) {

        this.validate(purchaseRequestDTO);

        LOGGER.info("Registering purchase request...");
        LOGGER.debug("PurchaseRequestDTO: {}", purchaseRequestDTO);

        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setRequester(purchaseRequestDTO.getRequester());
        purchaseRequest.setItemDescription(purchaseRequestDTO.getItemDescription());
        purchaseRequest.setProductValue(purchaseRequestDTO.getProductValue());
        purchaseRequest.setStatus(StatusPurchaseRequest.PENDING);

        purchaseRequest = this.purchaseRequestRepository.save(purchaseRequest);

        LOGGER.info("Purchase request of requester: {}", purchaseRequestDTO.getRequester() , " registered!");

        return PurchaseRequestDTO.of(purchaseRequest);
    }

    private void validate(PurchaseRequestDTO purchaseRequestDTO) {
        LOGGER.info("Validating purchase request...");

        if (purchaseRequestDTO == null) {
            throw new IllegalArgumentException("PurchaseRequestDTO cannot be null.");
        }

        if (StringUtils.isEmpty(purchaseRequestDTO.getRequester())) {
            throw new IllegalArgumentException("Requester cannot be null/empty.");
        }

        if (StringUtils.isEmpty(purchaseRequestDTO.getProductValue())) {
            throw new IllegalArgumentException("ProductValue cannot be null/empty.");
        }

    }

    public List<PurchaseRequest> getAllRequests() {
        List<PurchaseRequest> purchaseRequest = this.purchaseRequestRepository.findAll();

        return purchaseRequest;
    }


    public PurchaseRequestDTO updateStatusToApproved(Long id) {
        Optional<PurchaseRequest> purchaseRequestOptional = this.purchaseRequestRepository.findById(id);

        if (purchaseRequestOptional.isPresent()) {
            PurchaseRequest purchaseRequestExisting = purchaseRequestOptional.get();

            LOGGER.info("Updating status of purchaseRequest of id: [{}]", purchaseRequestExisting.getId());

            purchaseRequestExisting.setStatus(StatusPurchaseRequest.APPROVED);
            purchaseRequestExisting.setApproved(true);
            purchaseRequestExisting.setDisapproved(false);
            purchaseRequestExisting.setDisapprovedMessage("");

            purchaseRequestExisting = this.purchaseRequestRepository.save(purchaseRequestExisting);

            return PurchaseRequestDTO.of(purchaseRequestExisting);
        } else {
            throw new IllegalArgumentException(String.format("Id %s could not exist", id));
        }
    }

    public PurchaseRequestDTO updateStatusToDisapproved(Long id, PurchaseRequestDTO purchaseRequestDTO) {
        Optional<PurchaseRequest> purchaseRequestOptional = this.purchaseRequestRepository.findById(id);

        if (purchaseRequestOptional.isPresent()) {
            PurchaseRequest purchaseRequestExisting = purchaseRequestOptional.get();

            LOGGER.info("Updating status of purchaseRequest of id: [{}]", purchaseRequestExisting.getId());

            purchaseRequestExisting.setStatus(StatusPurchaseRequest.DISAPPROVED);
            purchaseRequestExisting.setDisapproved(true);
            purchaseRequestExisting.setApproved(false);
            purchaseRequestExisting.setDisapprovedMessage(purchaseRequestDTO.getDisapprovedMessage());

            purchaseRequestExisting = this.purchaseRequestRepository.save(purchaseRequestExisting);

            return PurchaseRequestDTO.of(purchaseRequestExisting);
        } else {
            throw new IllegalArgumentException(String.format("Id %s could not exist", id));
        }
    }
}
