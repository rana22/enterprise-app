/**
 * 
 */
package com.enterprise.capitalist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.enterprise.capitalist.model.EnterpriseTransactions;

/**
 * @author ambarrana -9/15/16 
 *
 */
public interface TransactionRepository extends JpaRepository<EnterpriseTransactions, Long>{
	
	List<EnterpriseTransactions> findAll();
	
	EnterpriseTransactions  findByTransactionId(String transactionId);
	
	List<EnterpriseTransactions> findByUserIdIgnoreCase(String userId);
	
	@Transactional
	Long  deleteByTransactionId(String transactionId);

}
