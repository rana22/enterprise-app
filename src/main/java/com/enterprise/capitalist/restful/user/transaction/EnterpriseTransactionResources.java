/**
 * 
 */
package com.enterprise.capitalist.restful.user.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.jvnet.hk2.config.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.capitalist.model.EnterpriseTransactions;
import com.enterprise.capitalist.repository.TransactionRepository;
import com.enterprise.capitalist.repository.service.impl.EnterpriseTransactionRepoServiceImpl;

/**
 * @author ambarrana - content 
 *
 */

@RestController
public class EnterpriseTransactionResources {
	
	private static final Logger log = LoggerFactory.getLogger(EnterpriseTransactionResources.class);
	
	@Inject 
	TransactionRepository transactionRepo;
	
	@Inject
	EnterpriseTransactionRepoServiceImpl transactionRepoServImpl;
	
	@RequestMapping(value="/getAll/transactions/{userId}", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public @ResponseBody ResponseEntity<List<EnterpriseTransactions>> getAllUserTransactions(@PathVariable("userId") String userId){
	
	List<EnterpriseTransactions> userTransactionList = new ArrayList<EnterpriseTransactions>();
	if(userId != null && userId.length() >0){
			log.info("getting all the transactoins for the userId = " + userId);
	 		userTransactionList = transactionRepo.findByUserIdIgnoreCase(userId);
		}else{
			log.debug("Provided userId is invalid = " + userId);
			return new ResponseEntity<List<EnterpriseTransactions>>(HttpStatus.BAD_REQUEST);
		}
	return new ResponseEntity<List<EnterpriseTransactions>>(userTransactionList, HttpStatus.OK);
	}
	
	@RequestMapping(value="/add/transaction/{userId}", method=RequestMethod.POST)
	public ResponseEntity<EnterpriseTransactions> addTransaction(@RequestBody EnterpriseTransactions addTransaction, @PathVariable("userId") String userId){
		if(userId != null && userId.length() >0){
			log.info("adding transaction for userId = " + userId);
			transactionRepo.save(addTransaction);
		}else{
			log.debug("Provided userId is invalid = " + userId);
			return new ResponseEntity<EnterpriseTransactions>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<EnterpriseTransactions>(addTransaction, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/delete/transaction/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<EnterpriseTransactions> deleteTransaction(@RequestBody EnterpriseTransactions transaction, @PathVariable("userId") String userId) throws Exception
	{
		log.info("delete the transaction for userId "+ userId);
		
		if(userId != null){
			Boolean isDeleted = transactionRepoServImpl.deleteTransaction(userId);
			if(isDeleted){
				log.debug("unable to delete the transaction with transaction_id = " + transaction.getTransactionId());
				return new ResponseEntity<EnterpriseTransactions>(HttpStatus.PRECONDITION_FAILED);
			}
		}
		log.info("transaction with the transactionalid " +transaction.getTransactionId() + " has been deleted");
		return new ResponseEntity<EnterpriseTransactions>(HttpStatus.OK);
	}
}
