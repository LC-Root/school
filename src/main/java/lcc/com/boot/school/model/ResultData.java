package lcc.com.boot.school.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResultData {
	
	private int code;
	
	private Object data;
	
	public static ResultData valueOf(int code, Object data) {
		ResultData resultData = new ResultData();
		resultData.setCode(code);
		resultData.setData(data);
		return resultData;
	}

}
