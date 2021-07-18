package lcc.com.boot.school.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns="/user/*")
public class RequestFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("MyFilter: "+ req.getRequestURI());
		
		HttpSession session = req.getSession();
		Long playerId = (Long) session.getAttribute("playerId");
		Map<String, Object> extraParams = new HashMap<String, Object>();
        extraParams.put("playerId", playerId);
        //利用原始的request对象创建自己扩展的request对象并添加自定义参数
        RequestParameterWrapper requestParameterWrapper = new RequestParameterWrapper(req);
        requestParameterWrapper.addParameters(extraParams);
;
		chain.doFilter(requestParameterWrapper, response);//这步使得请求能够继续传导下去，如果没有的话，请求就在此结束
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
