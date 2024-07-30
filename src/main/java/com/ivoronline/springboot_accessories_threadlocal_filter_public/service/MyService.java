package com.ivoronline.springboot_accessories_threadlocal_filter_public.service;

import com.ivoronline.springboot_accessories_threadlocal_filter_public.context.ThreadContext;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //=========================================================================================================
  // WITH THREAD LOCAL
  //=========================================================================================================
  public String withThreadLocal() {            // No Input Parameter Needed
    String  user = ThreadContext.user.get();
    Integer age  = ThreadContext.age .get();
    return user + " is " + age + " years old";
  }

  //=========================================================================================================
  // WITHOUT THREAD LOCAL
  //=========================================================================================================
  public String withoutThreadLocal(String user, Integer age) {
    return user + " is " + age + " years old";
  }
  
}
