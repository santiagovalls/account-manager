package com.amplify.accountmanager.core.domains.general.services.impl;

import com.amplify.accountmanager.core.domains.general.model.Account;
import com.amplify.accountmanager.core.domains.general.model.AccountStatus;
import com.amplify.accountmanager.core.domains.general.repository.AccountRepository;
import com.amplify.accountmanager.core.domains.general.services.AccountService;
import com.amplify.accountmanager.core.todo.TODOClass;
import java.util.List;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Santiago J. Valls.
 */
@Service
public class AccountServiceImpl extends AbstractService implements AccountService {

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  RabbitTemplate rabbitTemplate;

  @Scheduled(fixedRate = 60000)
  public void checkAccountsStatus() {
    List<Account> disabledAccounts = accountRepository.findByAccountStatus(AccountStatus.DISABLED);
    // TODO Improve code style & design pattern
    for (Account account : disabledAccounts) {
      if (checkIsActiveAgainByNetwork(account)) {
        saveAccountStatus(account);
        putAccountInStatusQueue(account);
      }
    }
  }

  private boolean checkIsActiveAgainByNetwork(Account disabledAccount) {
    switch (disabledAccount.getNetwork()) {
      case FACEBOOK:
        return TODOClass.checkFacebookAcoountStatus();
      case INSTAGRAM:
        return TODOClass.checkInstagramAcoountStatus();
      case FOURSQUARE:
        return TODOClass.checkFourSquareAccountStatus();
      case OPEN_STREET_MAP:
        return TODOClass.checkOpenStreetMapAccountStatus();
      case GOOGLE:
        return TODOClass.checkGoogleAccountStatus();
    }
    return false;
  }

  private void saveAccountStatus(Account account) {
    accountRepository.save(account.setStatus(AccountStatus.ENABLED));
  }

  private void putAccountInStatusQueue(Account account) {
    rabbitTemplate.convertAndSend(TODOClass.getStatusQueueName(), account);
  }
}
