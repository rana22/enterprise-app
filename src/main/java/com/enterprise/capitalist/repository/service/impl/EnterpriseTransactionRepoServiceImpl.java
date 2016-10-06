/**
 * 
 */
package com.enterprise.capitalist.repository.service.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.enterprise.capitalist.model.EnterpriseTransactions;
import com.enterprise.capitalist.repository.TransactionRepository;
import com.enterprise.capitalist.repository.service.EnterpriseTransactionRepoService;

/**
 * @author ambarrana
 *
 */
@Component
public class EnterpriseTransactionRepoServiceImpl implements EnterpriseTransactionRepoService{
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Inject
	TransactionRepository transactionRepo;
	
	public Boolean deleteTransaction(String transactionId) throws Exception{
		Boolean isDeleted = Boolean.FALSE;
		logger.debug("Delete transaction for the transaction_id " + transactionId);
		Long transactionDeleted = (Long) transactionRepo.deleteByTransactionId(transactionId);
		logger.debug("Transactoin with id " + transactionId+ "has been deleted.");
		if(transactionDeleted>0) isDeleted = Boolean.TRUE;
		return isDeleted;
	}
}
