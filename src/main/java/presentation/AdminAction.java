package presentation;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public AdminAction() {
		super();
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String execute() {
		return "success";
	}

}
