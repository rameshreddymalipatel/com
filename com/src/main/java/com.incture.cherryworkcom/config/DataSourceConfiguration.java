
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.zaxxer.hikari.HikariDataSource;

import io.pivotal.cfenv.core.CfCredentials;
import io.pivotal.cfenv.jdbc.CfJdbcEnv;

/**
 * @author INC00400 (Ramesh Reddy Malipatel)
 * @version 1.0.0
 * @since 01-Jan-2021
 */

@Configuration
@Profile("cloud")
@ServiceScan
public class DataSourceConfiguration extends AbstractCloudConfig {

	@Bean
	@Primary
	public DataSource datasource() {
		CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
		CfCredentials cfCredentials = cfJdbcEnv.findCredentialsByTag("hana");
		return DataSourceBuilder.create().type(HikariDataSource.class)
				.driverClassName(com.sap.db.jdbc.Driver.class.getName()).url(cfCredentials.getUri())
				.username(cfCredentials.getUsername()).password(cfCredentials.getPassword()).build();
	}
}
null
