package se.sakilagui.Controller;
import se.sakilagui.Model.PaymentEntity;
import se.sakilagui.Service.PaymentDBHandling;
import se.sakilagui.Service.PaymentInterface;

import java.util.List;

public class PaymentController implements PaymentInterface {
    @Override
    public List<PaymentEntity> getAllPayments() {
        PaymentDBHandling paymentDBHandling = new PaymentDBHandling();
        return paymentDBHandling.getAllPayments();
    }

    @Override
    public PaymentEntity getPaymentById(int id) {
        PaymentDBHandling paymentDBHandling = new PaymentDBHandling();
        return paymentDBHandling.getPaymentById(id);
    }

    @Override
    public void create(PaymentEntity payment) {
        PaymentDBHandling paymentDBHandling = new PaymentDBHandling();
        paymentDBHandling.create(payment);
    }

    @Override
    public void deletePaymentById(int id) {
        PaymentDBHandling paymentDBHandling = new PaymentDBHandling();
        paymentDBHandling.deletePaymentById(id);
    }

    @Override
    public PaymentEntity updatePayment(PaymentEntity payment) {
        PaymentDBHandling paymentDBHandling = new PaymentDBHandling();
        return paymentDBHandling.updatePayment(payment);
    }
}
