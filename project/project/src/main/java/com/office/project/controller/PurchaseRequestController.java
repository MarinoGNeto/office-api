package com.office.project.controller;

import com.office.project.dto.PurchaseRequestDTO;
import com.office.project.model.PurchaseRequest;
import com.office.project.service.PurchaseRequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/purchaseRequest")
public class PurchaseRequestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseRequestController.class);

    private final PurchaseRequestService purchaseRequestService;

    @Autowired
    public PurchaseRequestController(PurchaseRequestService purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    @PostMapping
    public PurchaseRequestDTO save(@RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        LOGGER.info("Receiving purchase request...");

        return this.purchaseRequestService.save(purchaseRequestDTO);
    }

    @GetMapping
    public List<PurchaseRequest> getAllRequests() {
        LOGGER.info("Searching for all requests...");

        return this.purchaseRequestService.getAllRequests();
    }

    @PutMapping("/approve/{id}")
    public PurchaseRequestDTO updateStatusToApproved(@PathVariable("id") Long id) {
        LOGGER.info("Starting process of updating status...");

        return this.purchaseRequestService.updateStatusToApproved(id);
    }

    @PutMapping("/disapprove/{id}")
    public PurchaseRequestDTO updateStatusToDisapproved(@PathVariable("id") Long id, @RequestBody PurchaseRequestDTO purchaseRequestDTO) {
        LOGGER.info("Starting process of updating status...");

        return this.purchaseRequestService.updateStatusToDisapproved(id, purchaseRequestDTO);
    }
}
