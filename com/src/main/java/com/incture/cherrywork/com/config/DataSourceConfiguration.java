

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;


import io.pivotal.cfenv.jdbc.CfJdbcEnv;
/**
 * @version 1.0.0
 */
@Configuration
@ServiceScan

	@Primary
		CfJdbcEnv cfJdbcEnv = new CfJdbcEnv();
		return DataSourceBuilder.create().type(HikariDataSource.class)
				.username(cfCredentials.getUsername()).password(cfCredentials.getPassword()).build();
}
