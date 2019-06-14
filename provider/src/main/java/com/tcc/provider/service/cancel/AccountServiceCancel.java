package com.tcc.provider.service.cancel;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.AccountOne;
import com.tcc.api.service.IAccountService;
import com.tcc.provider.dao.AccountServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service("accountServiceCancel")
public class AccountServiceCancel implements IAccountService {

	@Autowired
	private AccountServiceDao accountServiceDao;

	@Transactional(rollbackFor = ServiceException.class)
	public void increaseAmount(@RequestBody AccountOne accountOne) throws ServiceException {

		accountServiceDao.increaseAmountCancel(accountOne);
		System.out.printf("undo increase: acct= %s, amount= %7.2f%n", accountOne.getAcctId(), accountOne.getAmount());
	}

	@Transactional(rollbackFor = ServiceException.class)
	public void decreaseAmount(@RequestBody AccountOne accountOne) throws ServiceException {
		int a = accountServiceDao.decreaseAmountCancel(accountOne);
		System.out.printf("accountServiceCancel:"+a+" ==>undo decrease: acct= %s, amount= %7.2f%n", accountOne.getAcctId(), accountOne.getAmount());
	}

}
