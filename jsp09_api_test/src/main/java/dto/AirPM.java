package dto;

public class AirPM {
	private int sn;
	private String dataDate;
	private String issueTime;
	private String districtName;
	private String moveName;
	private String itemCode;
	private int issueVal; 
	private String issueGbn;
	public AirPM(int sn, String dataDate, String issueTime, String districtName, String moveName, String itemCode,
			int issueVal, String issueGbn) {
		super();
		this.sn = sn;
		this.dataDate = dataDate;
		this.issueTime = issueTime;
		this.districtName = districtName;
		this.moveName = moveName;
		this.itemCode = itemCode;
		this.issueVal = issueVal;
		this.issueGbn = issueGbn;
	}
	public AirPM() {
		super();
	}
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getDataDate() {
		return dataDate;
	}
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	public String getIssueTime() {
		return issueTime;
	}
	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public String getMoveName() {
		return moveName;
	}
	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getIssueVal() {
		return issueVal;
	}
	public void setIssueVal(int issueVal) {
		this.issueVal = issueVal;
	}
	public String getIssueGbn() {
		return issueGbn;
	}
	public void setIssueGbn(String issueGbn) {
		this.issueGbn = issueGbn;
	}
	@Override
	public String toString() {
		return "AirPM [sn=" + sn + ", dataDate=" + dataDate + ", issueTime=" + issueTime + ", districtName="
				+ districtName + ", moveName=" + moveName + ", itemCode=" + itemCode + ", issueVal=" + issueVal
				+ ", issueGbn=" + issueGbn + "]";
	}

	
	
}