package com.ecommerce.shoppers_store.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "payments")
public class Payment {
    @Id
    private String id;
    private String orderId;
    private String paymentId;
    private String status;
    private double amount;
    private String currency;
}
