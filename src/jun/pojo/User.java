package jun.pojo;

import java.io.Serializable;

public class User implements Serializable{

	private int sno;
	private String sname;
	private int sage;
	private String ssex;
	private String sdept;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	@Override
	public String toString() {
		return "User [sno=" + sno + ", sname=" + sname + ", sage=" + sage + ", ssex=" + ssex + ", sdept=" + sdept + "]";
	}
}
