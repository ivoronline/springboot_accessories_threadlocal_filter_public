package com.ivoronline.springboot_accessories_threadlocal_filter_public.filter;

import com.ivoronline.springboot_accessories_threadlocal_filter_public.context.ThreadContext;
import jakarta.servlet.*;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class MyFilter implements Filter {

  //=========================================================================================================
  // DO FILTER
  //=========================================================================================================
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    try {
    
      //GET URL PARAMETERS
      String  user      = request.getParameter("user");
      String  ageString = request.getParameter("age" ); //http://localhost:8080/favicon.ico
      Integer age       = ageString == null ? null : Integer.valueOf(ageString);
      
      //SET THREAD CONTEXT PARAMETERS
      ThreadContext.user.set(user);
      ThreadContext.age .set(age);
      
      //CALL NEXT FILTER
      chain.doFilter(request, response);
      
    } finally {
      //REMOVE THREAD CONTEXT PARAMETERS
      ThreadContext.user.remove();
      ThreadContext.age .remove();
      System.out.println("Thread Context Cleared");
    }
  }
  
}