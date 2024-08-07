package com.custom.exceptions.Repository;


import com.custom.exceptions.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
