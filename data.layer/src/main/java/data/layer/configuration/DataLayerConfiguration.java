package data.layer.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "data.layer")
@EntityScan(basePackages = "data.layer")
@EnableTransactionManagement
public class DataLayerConfiguration {

}
