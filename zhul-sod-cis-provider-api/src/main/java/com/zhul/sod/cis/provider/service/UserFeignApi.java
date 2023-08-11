package com.zhul.sod.cis.provider.service;

import com.zhul.cloud.common.wrapper.Wrapper;
import com.zhul.sod.cis.provider.fallback.UserServiceFallbackFactory;
import com.zhul.sod.cis.provider.response.UserQueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by yanglikai on 2020/12/22.
 */
@FeignClient(value = "zhul-sod-cis", fallbackFactory = UserServiceFallbackFactory.class)
public interface UserFeignApi {

  /**
   * 查询用户
   */
  @GetMapping(value = "/v1/users/{id}")
  Wrapper<UserQueryResponse> queryUser(@PathVariable(value = "id") Integer id);
}
