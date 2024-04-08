package se.sakilagui.Service;
import se.sakilagui.Model.PaymentEntity;

import java.util.List;

public interface PaymentInterface {
    void create(PaymentEntity payment);
    PaymentEntity getPaymentById(int id);
    List<PaymentEntity> getAllPayments();
    PaymentEntity updatePayment(PaymentEntity payment);
    void deletePaymentById(int id);
}
