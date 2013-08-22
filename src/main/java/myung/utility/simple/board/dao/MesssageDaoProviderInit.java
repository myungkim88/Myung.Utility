package myung.utility.simple.board.dao;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class MesssageDaoProviderInit {
	public void init(ServletConfig config) throws ServletException {
		String dbms=config.getInitParameter("dbms");
		if (dbms != null) {
			MessageDaoProvider.getInstance().setDbms(dbms);
		}
	}
}
