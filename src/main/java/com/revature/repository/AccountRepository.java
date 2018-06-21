package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.beans.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
