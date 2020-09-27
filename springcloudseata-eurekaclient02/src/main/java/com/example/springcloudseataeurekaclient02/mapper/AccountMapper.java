package com.example.springcloudseataeurekaclient02.mapper;

import com.example.springcloudseataeurekaclient02.bean.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 王飞
 * @since 2020-09-24
 */
@Component
@Mapper
public interface AccountMapper extends BaseMapper<Account> {


    @Select("select * from account where user_id=#{userid}")
    Account queryByUserid(long userid);
}
