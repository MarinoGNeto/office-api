package com.office.project.controller;


import com.office.project.dto.PurchaseRequestDTO;
import com.office.project.enums.StatusPurchaseRequest;
import com.office.project.service.PurchaseRequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;


@SpringBootTest
public class PurchaseRequestControllerTest {

    @Autowired
    private PurchaseRequestController purchaseRequestController;

    @MockBean
    private PurchaseRequestService purchaseRequestService;

    @BeforeEach
    public void setup() {
        standaloneSetup(this.purchaseRequestController);
    }

    @Test
    public void registerPurchaseRequestTest() {

        PurchaseRequestDTO purchaseRequestDTO = mock(PurchaseRequestDTO.class);

        when(this.purchaseRequestService.save(purchaseRequestDTO))
                .thenReturn(new PurchaseRequestDTO("Tester", "This description exist for test", 10.00, StatusPurchaseRequest.PENDING, false, false)
                );
    }
}
