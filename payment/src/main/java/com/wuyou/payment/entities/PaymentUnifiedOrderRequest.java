package com.wuyou.payment.entities;

import java.math.BigDecimal;

/**
 * @author hjn
 * @created 2019-01-07
 **/
public class PaymentUnifiedOrderRequest {

    private String paymentId;

    private BigDecimal totalFee;

    private String targetId;

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }
}
