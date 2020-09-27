package com.example.springcloudseataeurekaclient02.service.impl;

import com.example.springcloudseataeurekaclient02.bean.Account;
import com.example.springcloudseataeurekaclient02.mapper.AccountMapper;
import com.example.springcloudseataeurekaclient02.service.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}
