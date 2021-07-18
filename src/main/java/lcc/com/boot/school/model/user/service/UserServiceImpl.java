package lcc.com.boot.school.model.user.service;

import org.springframework.stereotype.Service;

import lcc.com.boot.school.common.util.Httprequest;
import lcc.com.boot.school.model.user.UserDef;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public String loginByWeixin(String code) {
        //发送    https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code 获取用户的openid和session_key
        //注意这个是 WeChatTool.wxspAppid 是微信小程序的appid 从微信小程序后台获取 WeChatTool.wxspSecret 这个也一样，我这里是用了常量来进行保存方便多次使用
        String params = "appid=" + UserDef.WX_APPID + "&secret=" + UserDef.WXS_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String sendGet = Httprequest.sendGet(UserDef.WX_CODE_URL, params); //发起请求拿到key和openid
        return sendGet;
	}

}
