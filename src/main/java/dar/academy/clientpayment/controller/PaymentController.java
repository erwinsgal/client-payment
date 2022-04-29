package dar.academy.clientpayment.controller;

import dar.academy.clientpayment.model.PaymentRequest;
import dar.academy.clientpayment.model.PaymentResponse;
import dar.academy.clientpayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/check")
    public String check(){
        return "client-payment is working";
    }


    @PostMapping
    public PaymentResponse createPayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.createPayment(paymentRequest);
    }

    @PutMapping
    public PaymentResponse updatePayment(@RequestParam String paymentId, @RequestBody PaymentRequest paymentRequest) {
        paymentRequest.setPaymentId(paymentId);
        return paymentService.updatePayment(paymentRequest);
    }

    @GetMapping
    public PaymentResponse getPaymentById(@RequestParam String paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @GetMapping("/all")
    public Page<PaymentResponse> getAllPayments(Pageable pageable){
        return paymentService.getAllPayments(pageable);
    }

    @GetMapping("/payer")
    public Page<PaymentResponse> getAllPaymentsByPayer(@RequestParam String payerId, Pageable pageable) {
        return paymentService.getPaymentsByPayerId(payerId, pageable);
    }

    @DeleteMapping
    public void deletePayment(@RequestParam String paymentId) {
        paymentService.deletePaymentById(paymentId);
    }
}
