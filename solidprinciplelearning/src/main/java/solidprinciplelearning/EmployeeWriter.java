package solidprinciplelearning;

public abstract class EmployeeWriter {
	private String path;
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public abstract void write(String employee);
}
