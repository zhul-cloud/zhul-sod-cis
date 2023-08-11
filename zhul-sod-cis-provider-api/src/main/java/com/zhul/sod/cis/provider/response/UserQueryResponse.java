package com.zhul.sod.cis.provider.response;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by yanglikai on 2020/12/22.
 */
@Data
public class UserQueryResponse implements Serializable {

  private Integer userId;

  private String userName;
}
