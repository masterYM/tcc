package com.tcc.consumer.service.impl;

import com.tcc.api.ServiceException;
import com.tcc.api.entity.AccountOne;
import com.tcc.api.entity.Transfer;
import com.tcc.api.service.IAccountService;
import com.tcc.consumer.dao.TransferDao;
import com.tcc.consumer.service.ITransferService;
import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Compensable(interfaceClass = ITransferService.class,
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
        this.acctService.decreaseAmount(accountOne);
        this.increaseAmount(transfer);
    }

    private void increaseAmount(@RequestBody  Transfer transfer) {
        this.transferDao.increaseAmount(transfer);
        System.out.printf("exec increase: acct= %s, amount= %7.2f%n", transfer.getTargetAcctId(), transfer.getAmount());
    }

}
