package com.example.springcloudseataeurekaclient03.controller;


import com.example.springcloudseataeurekaclient03.bean.Award;
import com.example.springcloudseataeurekaclient03.mapper.AwardMapper;
import com.example.springcloudseataeurekaclient03.returnmessage.ReturnMessage;
import com.example.springcloudseataeurekaclient03.service.AwardService;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 王飞
 * @since 2020-09-27
 */
@Controller
@RequestMapping("/award")
public class AwardController {

    @Resource
    AwardService awardService;
    @Resource
    AwardMapper awardMapper;


    @RequestMapping("/save")
    @ResponseBody
    public ReturnMessage saveaward(@RequestBody Map<String,Object> map ){
        String userId1=map.get("u1").toString();
        String money=map.get("money").toString();
        BigDecimal zzmoney=new BigDecimal(money);//转账金额


        Award award=new Award();
       award.setUserId(Long.valueOf(userId1));
       award.setIntegral(zzmoney);
       award.setCtime(LocalDateTime.now());

        Award award1=awardMapper.queryByUserId(Long.valueOf(userId1));
        if (ObjectUtils.isEmpty(award1)){
            awardMapper.insert(award);
        }else {
            award1.setIntegral(award1.getIntegral().add(zzmoney));
            awardMapper.updateById(award1);
        }
        return ReturnMessage.success();
    }

}

