package com.wirecard.challenge.model.type;

public enum PaymentStatus {
   APPROVED("Approved"), DENIED("Denied"), PENDING("Cancelled");

   private String description;

   PaymentStatus(String description) {
      this.description = description;
   }

   public String getDescription() {
      return this.description;
   }
}
