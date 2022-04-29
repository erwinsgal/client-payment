package dar.academy.clientpayment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface PaymentRepository extends ElasticsearchRepository<PaymentEntity, String> {

    Page<PaymentEntity> getPaymentEntitiesByPayerId(String payerId, Pageable pageable);
    PaymentEntity getPaymentEntityByPaymentId(String paymentId);
    void deletePaymentEntityByPaymentId(String paymentId);
    Page<PaymentEntity> getPaymentEntitiesBy(Pageable pageable);
}
