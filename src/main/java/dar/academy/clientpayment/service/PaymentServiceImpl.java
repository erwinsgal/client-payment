package dar.academy.clientpayment.service;

import dar.academy.clientpayment.model.PaymentRequest;
import dar.academy.clientpayment.model.PaymentResponse;
import dar.academy.clientpayment.repository.PaymentEntity;
import dar.academy.clientpayment.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {

        paymentRequest.setPaymentId(UUID.randomUUID().toString());

        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);

        paymentEntity = paymentRepository.save(paymentEntity);

        return modelMapper.map(paymentEntity, PaymentResponse.class);

    }

    @Override
    public PaymentResponse updatePayment(PaymentRequest paymentRequest) {

        PaymentEntity paymentEntity = modelMapper.map(paymentRequest, PaymentEntity.class);
        PaymentEntity dbEntity = paymentRepository.getPaymentEntityByPaymentId(paymentRequest.getPaymentId());
        paymentEntity.setPaymentId(dbEntity.getPaymentId());
        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public PaymentResponse getPaymentById(String paymentId) {

        PaymentEntity paymentEntity = paymentRepository.getPaymentEntityByPaymentId(paymentId);

        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }

    @Override
    public void deletePaymentById(String paymentId) {

        paymentRepository.deletePaymentEntityByPaymentId(paymentId);
    }

    @Override
    public Page<PaymentResponse> getPaymentsByPayerId(String payerId, Pageable pageable) {
        return paymentRepository.getPaymentEntitiesByPayerId(payerId, pageable).map(payment -> modelMapper.map(payment, PaymentResponse.class));

    }

    @Override
    public Page<PaymentResponse> getAllPayments(Pageable pageable) {
        return paymentRepository.getPaymentEntitiesBy(pageable).map(payment -> modelMapper.map(payment, PaymentResponse.class));
    }

}
