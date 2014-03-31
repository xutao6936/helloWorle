package com.thomas.myexample.utils;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.thomas.myexample.service.AcctDictList;

/**
 * @ClassName: AcctDictServlet
 * @Description: 将数据字典拉入内存中 servlet
 * @author XuTao
 * @date 2014-3-28 下午05:54:58
 * 
 */
public class AcctDictServlet extends HttpServlet {

	public static Logger log = LoggerFactory.getLogger(AcctDictServlet.class);
	private static final long serialVersionUID = 1L;

	private AcctDictList acctDictList;

	@Override
	public void init(ServletConfig config) throws ServletException {
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		acctDictList = wac.getBean(AcctDictList.class);
		doReload();
	}

	private void doReload() {
		log.info("+++++++++++++++++++开始加载数据字典++++++++++++++++++++++++");
		acctDictList.init();
		log.info("+++++++++++++++++++结束数据字典加载+++++++++++++++++++++++++");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = StringUtils.defaultString(req.getParameter("action"));
		resp.setContentType("text/html;charset=UTF-8");
		if ("reload".equals(action)) { // 重载
			// req.getSession().getServletContext();// 从req获取servletContext
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			acctDictList = wac.getBean(AcctDictList.class);
			doReload();
			resp.getWriter().print("<b>数据字典重载成功！</b>");
		}
	}

}
