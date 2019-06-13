package com.tcc.provider.dao;

import com.tcc.api.entity.AccountOne;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface AccountServiceDao {
//    String acctId, double amount
    int increaseAmount(AccountOne accountOne);
    int increaseAmountCancel(AccountOne accountOne);
    int increaseAmountConfirm(AccountOne accountOne);

    int decreaseAmount(AccountOne accountOne);
    int decreaseAmountCancel(AccountOne accountOne);
    int decreaseAmountConfirm(AccountOne accountOne);
}
