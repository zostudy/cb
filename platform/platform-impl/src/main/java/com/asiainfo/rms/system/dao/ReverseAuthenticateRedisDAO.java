package com.asiainfo.rms.system.dao;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.asiainfo.rms.system.domain.ReverseAuthenticateRepostitory;
import com.asiainfo.rms.system.redis.dao.BaseRedisDAO;

import lombok.Getter;

@Getter
@Repository
public class ReverseAuthenticateRedisDAO extends BaseRedisDAO<ReverseAuthenticateRepostitory, Object, Object> {
	
	private final String KEY_PREFIX_SET = "com:asiainfo:rms:system:domain.set.reverseauthenticate.";
	private final String KEY_PREFIX_HASH = "com:asiainfo:rms:system:domain.hash.reverseauthenticate.";
	private final String KEY_PREFIX_LIST = "com:asiainfo:rms:system:domain.list.reverseauthenticate.";
	private final String KEY_PREFIX_ZSET = "com:asiainfo:rms:system:domain.zset.reverseauthenticate.";
	private final String KEY_PREFIX_VALUE = "com:asiainfo:rms:system:domain.value.reverseauthenticate.";
	
	
	@Override
	public String valueKey(String correct, ReverseAuthenticateRepostitory user) {
		return this.KEY_PREFIX_VALUE + (StringUtils.isBlank(correct) ? "" : StringUtils.trim(correct)) + user.getStaffId();
	}
	
	@Override
	public String listKey(String correct, ReverseAuthenticateRepostitory user) {
		return this.KEY_PREFIX_LIST + (StringUtils.isBlank(correct) ? "" : StringUtils.trim(correct)) + user.getStaffId();
	}
	
	@Override
	public String setKey(String correct, ReverseAuthenticateRepostitory user) {
		return this.KEY_PREFIX_SET + (StringUtils.isBlank(correct) ? "" : StringUtils.trim(correct)) + user.getStaffId();
	}
	
	@Override
	public String zsetKey(String correct, ReverseAuthenticateRepostitory user) {
		return this.KEY_PREFIX_ZSET + (StringUtils.isBlank(correct) ? "" : StringUtils.trim(correct)) + user.getStaffId();
	}
	
	@Override
	public String hashKey(String correct, ReverseAuthenticateRepostitory user) {
		return this.KEY_PREFIX_HASH + (StringUtils.isBlank(correct) ? "" : StringUtils.trim(correct)) + user.getStaffId();
	}

}
