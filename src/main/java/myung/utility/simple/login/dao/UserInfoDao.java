/**
 * 
 */
package myung.utility.simple.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
			+ "(memberId, password, firstname, lastname, billingAddress, mailingAddress, "
			+ "emailAddress, registeredDate, lastActiveDate, allowMail) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECT_AN_USER = "SELECT * FROM userInfo where memberId = ?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM userInfo";
	private static final String DELETE_AN_USER = "DELETE FROM userInfo WHERE memberId=?";
	private static final String UPDATE_AN_USER = "UPDATE userInfo SET password=?, "
			+ "lastModifiedDate=?, allowMail=? where memberId=?";

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
						userInfo.getFirstname(), userInfo.getLastname(),
						userInfo.getBillingAddress(),
						userInfo.getMailingAddress(),
						userInfo.getEmailAddress(), new Date(), new Date(),
						userInfo.getAllowMail() });
	}

	public void deleteUserInfo(UserInfo userInfo) {
		getJdbcTemplate().update(DELETE_AN_USER,
				new Object[] { userInfo.getMemberId() });
	}

	public void udpateUserInfo(UserInfo userInfo) {
		getJdbcTemplate().update(
				UPDATE_AN_USER,
				new Object[] { userInfo.getPassword(), new Date(),
						userInfo.getAllowMail() });
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
		userInfo.setFirstname(rs.getString("firstname"));
		userInfo.setLastname(rs.getString("lastname"));
		userInfo.setBillingAddress(rs.getString("billingAddress"));
		userInfo.setMailingAddress(rs.getString("mailingAddress"));
		userInfo.setEmailAddress(rs.getString("emailAddress"));
		userInfo.setRegisteredDate(rs.getDate("registeredDate"));
		userInfo.setLastActiveDate(rs.getDate("lastActiveDate"));
		userInfo.setAllowMail(rs.getBoolean("allowMail"));

		return userInfo;
	}
}