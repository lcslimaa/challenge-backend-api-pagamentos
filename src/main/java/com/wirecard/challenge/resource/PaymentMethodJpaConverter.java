package com.wirecard.challenge.resource;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.wirecard.challenge.model.type.PaymentMethod;

@Converter
public class PaymentMethodJpaConverter implements AttributeConverter<PaymentMethod, String> {

    @Override
    public String convertToDatabaseColumn(PaymentMethod paymentMethod) {
        if (paymentMethod == null) {
            return null;
        }
        return paymentMethod.toString();
    }

    @Override
    public PaymentMethod convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        try {
            return PaymentMethod.valueOf(s);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
