package com.amplify.accountmanager.core.domains.general.model;

/**
 * @author Santiago J. Valls.
 */
public class Account {

  private SocialNetwork network;

  private String accountNumber;

  private String accessToken;

  private String pageId;

  private AccountStatus status;

  public SocialNetwork getNetwork() {
    return network;
  }

  public Account setNetwork(SocialNetwork network) {
    this.network = network;
    return this;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public Account setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public Account setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  public String getPageId() {
    return pageId;
  }

  public Account setPageId(String pageId) {
    this.pageId = pageId;
    return this;
  }

  public AccountStatus getStatus() {
    return status;
  }

  public Account setStatus(AccountStatus status) {
    this.status = status;
    return this;
  }
}
