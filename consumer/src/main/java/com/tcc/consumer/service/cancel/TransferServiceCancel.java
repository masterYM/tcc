package com.tcc.consumer.service.cancel;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.Transfer;
import com.tcc.consumer.dao.TransferDao;
import com.tcc.consumer.service.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transferServiceCancel")
public class TransferServiceCancel implements ITransferService {
	@Autowired
	private TransferDao transferDao;


	@Transactional(rollbackFor = ServiceException.class)
//	public void transfer(String sourceAcctId, String targetAcctId, double amount) throws ServiceException {
	public void transfer(Transfer transfer) throws ServiceException {
		transferDao.cancelIncrease(transfer);
		System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", transfer.getTargetAcctId(), transfer.getAmount());
	}

}
