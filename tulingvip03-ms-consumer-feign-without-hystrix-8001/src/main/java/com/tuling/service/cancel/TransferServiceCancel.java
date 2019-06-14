package com.tuling.service.cancel;

import com.tuling.api.ServiceException;
import com.tuling.dao.TransferDao;
import com.tuling.entity.Transfer;
import com.tuling.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferServiceCancel")
public class TransferServiceCancel implements ITransferService {
	@Autowired
	private TransferDao transferDao;


	@Transactional(rollbackFor = ServiceException.class)
	public void transfer(Transfer transfer) throws ServiceException {
		int a = transferDao.cancelIncrease(transfer);
		System.out.printf("ITransferService:"+a+"==>exec decrease: acct= %s, amount= %7.2f%n", transfer.getTargetAcctId(), transfer.getAmount());
	}

}
