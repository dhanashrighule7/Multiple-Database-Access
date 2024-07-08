package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ChainedTransactionManagerConfig {

	@Bean(name = "chainedTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("primaryTransactionManager") PlatformTransactionManager primaryTransactionManager,
			@Qualifier("secondaryTransactionManager") PlatformTransactionManager secondaryTransactionManager) {
		return new ChainedTransactionManager(primaryTransactionManager, secondaryTransactionManager);
	}
}
