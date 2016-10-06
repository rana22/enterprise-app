/**
 * 
 */
package com.enterprise.capitalist.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.enterprise.capitalist.model.EnterpriseTransactions;

/**
 * @author ambarrana -9/15/16 
 *
 */
public interface TransactionRepository <EnterpriseTransaction, Long>{
	
	List<EnterpriseTransactions> findAll();
	
	EnterpriseTransactions  findByTransactionalId(String transactionId);
	
	@Transactional
	Long  deleteByTransactionalId(String transactionId);

}
