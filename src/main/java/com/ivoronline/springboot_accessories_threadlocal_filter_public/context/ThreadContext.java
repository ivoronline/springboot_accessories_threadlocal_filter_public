package com.ivoronline.springboot_accessories_threadlocal_filter_public.context;

public class ThreadContext {
  public static final ThreadLocal<String>  user = new ThreadLocal<>();
  public static final ThreadLocal<Integer> age  = new ThreadLocal<>();
}
