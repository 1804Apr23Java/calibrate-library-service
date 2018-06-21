package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Account;

import com.revature.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountrepository;

	public Account findAccountbyId(int id) {
		return accountrepository.getOne(id);
	}
	
	
}
