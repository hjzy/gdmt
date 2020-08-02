package com.train.gdmt.contract.service.impl;

import com.train.gdmt.contract.dao.ContractDao;
import com.train.gdmt.contract.model.Contract;
import com.train.gdmt.contract.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDao contractDao;

    @Override
    public Contract login(String username)
    {
        return contractDao.getUser(username);
    }
}
