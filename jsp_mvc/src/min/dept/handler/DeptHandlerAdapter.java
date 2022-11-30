package min.dept.handler;

public class DeptHandlerAdapter {
	private boolean redirect = false; // true면 redirect, false면 forward
	private String path = null; // 경로를 설정하여 저장하고자 하는 파일을 저장

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
