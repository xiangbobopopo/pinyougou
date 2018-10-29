package entity;
//
import java.io.Serializable;

public class Result implements Serializable{

	private boolean successs;
	private String success;

	public Result(boolean successs, String success) {
		this.successs = successs;
		this.success = success;
	}

	public boolean isSuccesss() {
		return successs;
	}

	public void setSuccesss(boolean successs) {
		this.successs = successs;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}
}
