package lcc.com.boot.school.model.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lcc.com.boot.school.common.util.AesCbcUtil;
import lcc.com.boot.school.model.ResultData;
import lcc.com.boot.school.model.admin.message.School;
import lcc.com.boot.school.model.user.service.UserService;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	@ResponseBody
    public List<School> hello(Long playerId) {
		List<School> schools = new ArrayList<>();
		schools.add(new School(1, "发1"));
		schools.add(new School(2, "发2"));
		schools.add(new School(3, "发3"));
        return schools;
    }

	/**
	 * 微信登录
	 * @param session
	 * @param code
	 * @param encryptedData
	 * @param iv
	 * @return
	 */
	@RequestMapping("/loginByWeixin")
	@ResponseBody
	public ResultData loginByWeixin(HttpSession session, String code, String encryptedData, String iv) {
		String sendGet = userService.loginByWeixin(code);

		JSONObject json = JSONObject.fromObject(sendGet);
		System.out.println("返回过来的json数据:" + json.toString());
		Object errcode  = json.get("errcode");
		if (errcode != null && Integer.valueOf(errcode.toString()) != 0) {
			return ResultData.valueOf(Integer.valueOf(errcode.toString()), json);
		}
		String sessionkey = json.get("session_key").toString(); // 会话秘钥
		String openid = json.get("openid").toString(); // 用户唯一标识
		
		long palyerId = 1l;
		try {
			// 拿到用户session_key和用户敏感数据进行解密，拿到用户信息。
			String decrypts = AesCbcUtil.decrypt(encryptedData, sessionkey, iv, "utf-8");// 解密
			JSONObject jsons = JSONObject.fromObject(decrypts);
			
			session.setAttribute("playerId", palyerId);
			
			return ResultData.valueOf(1, jsons.put("palyerId", palyerId));
		} catch (Exception e) {
			e.printStackTrace();
			return ResultData.valueOf(-1, null);
		}
	}

}
