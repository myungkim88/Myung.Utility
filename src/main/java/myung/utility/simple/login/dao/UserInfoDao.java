/**
 * 
 */
package myung.utility.simple.login.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import myung.utility.simple.login.model.UserInfo;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author MyungHo Kim myungho.mortimen@gmail.com
 * 
 */
public class UserInfoDao extends JdbcDaoSupport {
	private static final String ADD_NEW_USER = "INSERT INTO userInfo "
			+ "(memberId, password, fullname, emailAddress) VALUES (?,?,?,?)";
	private static final String SELECT_AN_USER = "SELECT * FROM userInfo where memberId = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM userInfo";
	private static final String DELETE_AN_USER = "DELETE FROM userInfo WHERE memberId=?";

	/**
	 * @param memberId
	 *            member Id
	 * @return return userInfo
	 */
	public UserInfo getUserInfo(String memberId) {
		UserInfo userInfo = null;
		List<Object> userInfos = getJdbcTemplate().query(SELECT_AN_USER,
				new Object[] { memberId }, new UserInfoRowMapper());
		if (userInfos != null && userInfos.size() == 1) {
			userInfo = (UserInfo) userInfos.get(0);
		}

		return userInfo;
	}

	public void insertUserInfo(UserInfo userInfo) {
		// TODO: set registered date, and last active date
		getJdbcTemplate().update(
				ADD_NEW_USER,
				new Object[] { userInfo.getMemberId(), userInfo.getPassword(),
						userInfo.getName(), userInfo.getEmailAddress() });
	}

	public void deleteUserInfo(UserInfo userInfo) {
		getJdbcTemplate().update(DELETE_AN_USER,
				new Object[] { userInfo.getMemberId() });
	}

}

class UserInfoRowMapper implements RowMapper {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
	 *      int)
	 */

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo userInfo = new UserInfo();
		userInfo.setMemberId(rs.getString("memberId"));
		userInfo.setPassword(rs.getString("password"));
		userInfo.setName(rs.getString("memberId"));
		userInfo.setEmailAddress(rs.getString("email"));

		return userInfo;
	}
}