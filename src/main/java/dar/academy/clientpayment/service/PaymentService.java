package dar.academy.clientpayment.service;

import dar.academy.clientpayment.model.PaymentRequest;
import dar.academy.clientpayment.model.PaymentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    PaymentResponse createPayment(PaymentRequest paymentRequest);
    PaymentResponse updatePayment(PaymentRequest paymentRequest);
    PaymentResponse getPaymentById(String paymentId);
    void deletePaymentById(String paymentId);
    Page<PaymentResponse> getPaymentsByPayerId(String payerId, Pageable pageable);
    Page<PaymentResponse> getAllPayments(Pageable pageable);
}
