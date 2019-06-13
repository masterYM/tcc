package com.tcc.consumer.service.confirm;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.Transfer;
import com.tcc.consumer.dao.TransferDao;
import com.tcc.consumer.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferServiceConfirm")
public class TransferServiceConfirm implements ITransferService {

	@Autowired
	private TransferDao transferDao;

	@Transactional(rollbackFor = ServiceException.class)
	public void transfer(Transfer transfer) throws ServiceException {
//	public void transfer(String sourceAcctId, String targetAcctId, double amount) throws ServiceException {
		transferDao.confirmIncrease(transfer);
		System.out.printf("done increase: acct= %s, amount= %7.2f%n", transfer.getTargetAcctId(), transfer.getAmount());
	}

}
