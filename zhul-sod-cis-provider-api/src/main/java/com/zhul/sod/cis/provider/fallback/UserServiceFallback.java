package com.zhul.sod.cis.provider.fallback;

import com.zhul.cloud.common.wrapper.Wrapper;
import com.zhul.sod.cis.provider.response.UserQueryResponse;
import com.zhul.sod.cis.provider.service.UserFeignApi;

/**
 * Created by yanglikai on 2020/12/14.
 */
public class UserServiceFallback implements UserFeignApi {

  private Throwable throwable;

  public UserServiceFallback(Throwable throwable) {
    this.throwable = throwable;
  }

  @Override
  public Wrapper<UserQueryResponse> queryUser(Integer id) {
    return null;
  }
}
