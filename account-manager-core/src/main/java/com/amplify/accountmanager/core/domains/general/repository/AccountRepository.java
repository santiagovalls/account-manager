package com.amplify.accountmanager.core.domains.general.repository;

import com.amplify.accountmanager.core.domains.general.model.Account;
import com.amplify.accountmanager.core.domains.general.model.AccountStatus;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Santiago J. Valls.
 */
public interface AccountRepository extends MongoRepository<Account, String> {

  List<Account> findByAccountStatus(AccountStatus accountStatus);
}
