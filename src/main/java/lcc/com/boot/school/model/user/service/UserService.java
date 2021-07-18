package lcc.com.boot.school.model.user.service;

public interface UserService {

	/**
	 * 根据code去调用接口获取用户openid和session_key
	 * @param code
	 * @return
	 */
	String loginByWeixin(String code);

}
