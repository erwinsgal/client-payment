package dar.academy.clientpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PaymentResponse {

    private String paymentId;
    private String payerId;
    private String companyName;
    private Date date;
    private String serviceType;
    private String paymentAmount;
}
