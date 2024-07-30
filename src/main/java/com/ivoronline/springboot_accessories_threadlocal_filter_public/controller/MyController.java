package com.ivoronline.springboot_accessories_threadlocal_filter_public.controller;

import com.ivoronline.springboot_accessories_threadlocal_filter_public.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired MyService myService;

  //=========================================================================================================
  // WITH THREAD LOCAL
  //=========================================================================================================
  @RequestMapping("withThreadLocal")
  String withThreadLocal() {
    return myService.withThreadLocal(); //No Input Parameters Needed
  }

  //=========================================================================================================
  // WITHOUT THREAD LOCAL
  //=========================================================================================================
  @RequestMapping("withoutThreadLocal")
  String withoutThreadLocal(@RequestParam String user, @RequestParam Integer age) {
    return myService.withoutThreadLocal(user, age);
  }

}
