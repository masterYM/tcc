package com.tcc.provider.service.impl;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.AccountOne;
import com.tcc.api.service.IAccountService;
import com.tcc.provider.dao.AccountServiceDao;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Compensable(interfaceClass = IAccountService.class,
		confirmableKey = "accountServiceConfirm",
		cancellableKey = "accountServiceCancel")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountServiceDao accountServiceDao;

	@Transactional(rollbackFor = ServiceException.class)
	public void increaseAmount(AccountOne accountOne) throws ServiceException {
//		this.jdbcTemplate.update("update tb_account_one set frozen = frozen + ? where acct_id = ?", amount, acctId);

		int r = accountServiceDao.increaseAmount(accountOne);
		System.out.println(r);
		System.out.printf("exec increase: acct= %s, amount= %7.2f%n",  accountOne.getAcctId(), accountOne.getAmount());
	}

	@Transactional(rollbackFor = ServiceException.class)
	public void decreaseAmount(AccountOne accountOne) throws ServiceException {
//		this.jdbcTemplate.update("update tb_account_one set amount = amount - ?, frozen = frozen + ? where acct_id = ?", amount,
//				amount, acctId);
		accountServiceDao.decreaseAmount(accountOne);
		System.out.printf("exec decrease: acct= %s, amount= %7.2f%n",  accountOne.getAcctId(), accountOne.getAmount());
	}

}
