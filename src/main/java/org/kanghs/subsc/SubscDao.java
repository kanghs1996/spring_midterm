package org.kanghs.subsc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SubscDao {
	// 구독
	static final String ADD_SUBSC = "insert subscription(userId,name,channelId,title) values(?,?,?,?)";
	// 해제
	static final String DELETE_SUBSC = "delete from subscription where (userId,channelId)=(?,?)";
	// 목록
	static final String LIST_SUBSC = "select channelId,title from subscription where userId=?";
	// 구독
	@Autowired
	JdbcTemplate jdbcTemplate;

	RowMapper<Subsc> subscRowMapper = new BeanPropertyRowMapper<>(Subsc.class);

	public int addSubsc(Subsc subsc) {
		return jdbcTemplate.update(ADD_SUBSC, subsc.getUserId(), subsc.getName(), subsc.getChannelId(),
				subsc.getTitle());
	}

	// 해제
	public int deleteSubsc(String userId, String channelId) {
		return jdbcTemplate.update(DELETE_SUBSC, userId, channelId);
	}

	// 목록
	public List<Subsc> listSubsc(String userId) {
		return jdbcTemplate.query(LIST_SUBSC, this.subscRowMapper, userId);
	}
}
