package dar.academy.clientpayment.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class ElasticConfig extends AbstractElasticsearchConfiguration {

    @Override
    public RestHighLevelClient elasticsearchClient() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder().connectedTo("client-payment-839339.es.us-central1.gcp.cloud.es.io:9243").usingSsl().
                withBasicAuth("elastic","4ZT0C53I8bt9SJFZgS256cn4").build();

        return RestClients.create(clientConfiguration).rest();
    }
}
