package dar.academy.clientpayment.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "payment-test")

public class PaymentEntity {

    @Id
    @Field(type = FieldType.Keyword)
    private String paymentId;
    @Field(type = FieldType.Keyword)
    private String payerId;
    @Field(type = FieldType.Text)
    private String companyName;
    @Field(type = FieldType.Date, format = DateFormat.year_month_day, pattern = "yyyy-mm-dd")
    private Date date;
    @Field(type = FieldType.Text)
    private String serviceType;
    @Field(type = FieldType.Text)
    private String paymentAmount;

}
