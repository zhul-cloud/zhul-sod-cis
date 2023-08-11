package com.zhul.sod.cis.provider.rpc;

import com.zhul.cloud.common.wrapper.WrapMapper;
import com.zhul.cloud.common.wrapper.Wrapper;
import com.zhul.sod.cis.provider.response.UserQueryResponse;
import com.zhul.sod.cis.provider.service.UserFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanglikai on 2020/12/22.
 */
@Slf4j
@RestController
@ConditionalOnProperty(name = "spring.application.name", havingValue = "zhul-sod-cis")
public class UserFeignClient implements UserFeignApi {

  @Override
  public Wrapper<UserQueryResponse> queryUser(Integer id) {
    UserQueryResponse response = new UserQueryResponse();
    response.setUserId(id);
    response.setUserName("李四");

    return WrapMapper.ok(response);
  }
}
