package com.office.project.model;

import com.office.project.enums.StatusPurchaseRequest;

import javax.persistence.*;

@Entity
@Table(name = "purchase_request")
public class PurchaseRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "requester", nullable = false, length = 100)
    private String requester;
    @Column(name = "item_description", length = 255)
    private String itemDescription;
    @Column(name = "product_value", nullable = false)
    private Double productValue;
    @Column(name = "status", nullable = false, length = 15)
    private StatusPurchaseRequest status;
    @Column(name = "approved")
    private Boolean approved;
    @Column(name = "disapproved")
    private Boolean disapproved;
    @Column(name = "disapproved_Message", length = 100)
    private String disapprovedMessage;

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
        return "PurchaseRequest{" +
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
