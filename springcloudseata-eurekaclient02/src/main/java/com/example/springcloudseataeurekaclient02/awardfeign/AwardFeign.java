package com.example.springcloudseataeurekaclient02.awardfeign;

import com.example.springcloudseataeurekaclient02.returnmessage.ReturnMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 王飞
 * @Date: 2020/09/24/10:27
 * @Description:
 */
@FeignClient("award")//调用奖励服务
@Component
public interface AwardFeign {

    @PostMapping("/award/save")
    ReturnMessage saveAward(Map<String, Object> map);

}
