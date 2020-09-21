package com.office.project.dto;

import com.office.project.enums.StatusPurchaseRequest;
import com.office.project.model.PurchaseRequest;

import javax.validation.constraints.Pattern;

public class PurchaseRequestDTO {

    private Long id;
    private String requester;
    private String itemDescription;
    @Pattern(regexp = "^[1-9]\\d{0,2}(\\.\\d{3})*,\\d{2}$")
    private Double productValue;
    private StatusPurchaseRequest status;
    private Boolean approved;
    private Boolean disapproved;
    private String disapprovedMessage;

    public PurchaseRequestDTO() {
    }

    public PurchaseRequestDTO(StatusPurchaseRequest status, Boolean approved, Boolean disapproved, String disapprovedMessage) {
        this.status = status;
        this.approved = approved;
        this.disapproved = disapproved;
        this.disapprovedMessage = disapprovedMessage;
    }

    public PurchaseRequestDTO(String requester, String itemDescription, Double productValue, Boolean approved, Boolean disapproved) {
        this.requester = requester;
        this.itemDescription = itemDescription;
        this.productValue = productValue;
        this.approved = approved;
        this.disapproved = disapproved;
    }

    public PurchaseRequestDTO(String requester, String itemDescription, Double productValue, StatusPurchaseRequest status, Boolean approved, Boolean disapproved) {
        this.requester = requester;
        this.itemDescription = itemDescription;
        this.productValue = productValue;
        this.status = status;
        this.approved = approved;
        this.disapproved = disapproved;
    }

    public PurchaseRequestDTO(Long id, String requester, String itemDescription, Double productValue, StatusPurchaseRequest status, Boolean approved, Boolean disapproved, String disapprovedMessage) {
        this.id = id;
        this.requester = requester;
        this.itemDescription = itemDescription;
        this.productValue = productValue;
        this.status = status;
        this.approved = approved;
        this.disapproved = disapproved;
        this.disapprovedMessage = disapprovedMessage;
    }

    public static PurchaseRequestDTO of(PurchaseRequest purchaseRequest) {
        return new PurchaseRequestDTO(
                purchaseRequest.getId(),
                purchaseRequest.getRequester(),
                purchaseRequest.getItemDescription(),
                purchaseRequest.getProductValue(),
                purchaseRequest.getStatus(),
                purchaseRequest.getApproved(),
                purchaseRequest.getDisapproved(),
                purchaseRequest.getDisapprovedMessage()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Double getProductValue() {
        return productValue;
    }

    public void setProductValue(Double productValue) {
        this.productValue = productValue;
    }

    public StatusPurchaseRequest getStatus() {
        return status;
    }

    public void setStatus(StatusPurchaseRequest status) {
        this.status = status;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Boolean getDisapproved() {
        return disapproved;
    }

    public void setDisapproved(Boolean disapproved) {
        this.disapproved = disapproved;
    }

    public String getDisapprovedMessage() {
        return disapprovedMessage;
    }

    public void setDisapprovedMessage(String disapprovedMessage) {
        this.disapprovedMessage = disapprovedMessage;
    }

    @Override
    public String toString() {
        return "PurchaseRequestDTO{" +
                "id=" + id +
                ", requester='" + requester + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", productValue='" + productValue + '\'' +
                ", status='" + status + '\'' +
                ", approved='" + approved + '\'' +
                ", disapproved='" + disapproved + '\'' +
                ", disapprovedMessage='" + disapprovedMessage + '\'' +
                '}';
    }
}
