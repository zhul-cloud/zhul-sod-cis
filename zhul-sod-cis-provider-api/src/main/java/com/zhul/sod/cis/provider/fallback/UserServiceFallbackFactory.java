package com.zhul.sod.cis.provider.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikai on 2020/12/14.
 */
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserServiceFallback> {

  @Override
  public UserServiceFallback create(Throwable throwable) {
    return new UserServiceFallback(throwable);
  }
}
