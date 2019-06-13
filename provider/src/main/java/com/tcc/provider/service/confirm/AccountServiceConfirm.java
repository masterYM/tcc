package com.tcc.provider.service.confirm;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.AccountOne;
import com.tcc.api.service.IAccountService;
import com.tcc.provider.dao.AccountServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountServiceConfirm")
public class AccountServiceConfirm implements IAccountService {

	@Autowired
	private AccountServiceDao accountServiceDao;

	@Transactional(rollbackFor = ServiceException.class)
	public void increaseAmount(AccountOne accountOne) throws ServiceException {
//		this.jdbcTemplate.update("update tb_account_one set amount = amount + ?, frozen = frozen - ? where acct_id = ?", amount,
//				amount, acctId);

		accountServiceDao.increaseAmountConfirm(accountOne);
		System.out.printf("done increase: acct= %s, amount= %7.2f%n", accountOne.getAcctId(), accountOne.getAmount());
	}

	@Transactional(rollbackFor = ServiceException.class)
	public void decreaseAmount(AccountOne accountOne) throws ServiceException {
//		this.jdbcTemplate.update("update tb_account_one set frozen = frozen - ? where acct_id = ?", amount, acctId);

		accountServiceDao.decreaseAmountConfirm(accountOne);
		System.out.printf("done decrease: acct= %s, amount= %7.2f%n", accountOne.getAcctId(), accountOne.getAmount());
	}

}