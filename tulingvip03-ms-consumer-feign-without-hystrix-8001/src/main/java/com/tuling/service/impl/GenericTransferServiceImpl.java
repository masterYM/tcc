package com.tuling.service.impl;

import com.tuling.api.IAccountService;
import com.tuling.api.ServiceException;
import com.tuling.dao.TransferDao;
import com.tuling.entity.AccountOne;
import com.tuling.entity.Transfer;
import com.tuling.service.ITransferService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Compensable(
        interfaceClass = ITransferService.class,
        confirmableKey = "transferServiceConfirm",
        cancellableKey = "transferServiceCancel")
@RestController
public class GenericTransferServiceImpl implements ITransferService {

    @Autowired
    private TransferDao transferDao;

    @Autowired
    private IAccountService acctService;

    @Transactional
    public void transfer(@RequestBody Transfer transfer) throws ServiceException {
        AccountOne accountOne = new AccountOne();
        accountOne.setAcctId(transfer.getSourceAcctId());
        accountOne.setAmount(transfer.getAmount());
        this.increaseAmount(transfer);
        this.acctService.decreaseAmount(accountOne);
    }
    private void increaseAmount(Transfer transfer) {
        int a = this.transferDao.increaseAmount(transfer);
        System.out.printf("GenericTransferServiceImpl:" + a +"==>exec increase: acct= %s, amount= %7.2f%n", transfer.getTargetAcctId(), transfer.getAmount());
    }

}
