package com.enterprise.capitalist.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"transaction_id"})})
public class EnterpriseTransactions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 966254216670231194L;
	
	@GeneratedValue(strategy=GenerationType.AUTO)
 	@Column(name="id")
    private Long id;
	
	@Id
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="transaction_name")
	private String transactionName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="transaction_date")
	private Timestamp trasactionDate;
	
	@Column(name="lob")
	private String lob;
	
	@Column(name="transaction_amt")
	private double transactionAmt;
	
	@Column(name="transaction_status")
	private String status;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="transaction_location")
	private String transactionLocation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTrasactionDate() {
		return trasactionDate;
	}

	public void setTrasactionDate(Timestamp trasactionDate) {
		this.trasactionDate = trasactionDate;
	}

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public double getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
