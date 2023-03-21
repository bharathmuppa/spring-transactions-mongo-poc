package com.example.demo.configuration;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.support.ResourceTransactionManager;

@Configuration
public class MongoConfiguration {

	@Bean
	ResourceTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
		TransactionOptions txnOptions = TransactionOptions.builder().readPreference(ReadPreference.primary())
				.readConcern(ReadConcern.LOCAL).writeConcern(WriteConcern.MAJORITY).build();
		return new MongoTransactionManager(dbFactory, txnOptions);
	}
}
