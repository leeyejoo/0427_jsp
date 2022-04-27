package dto;

public class Covid {
	private int seq;
	private String stateDt;
	private String stateTime;
	private int deathCnt;
	private int decideCnt; //누적확진자수
	private int dailyDecideCnt; //일일확진자수
	private String createDt;
	private String updateDt;
	
	public Covid() {
		super();
	}



	public Covid(int seq, String stateDt, String stateTime, int deathCnt, int decideCnt, int dailyDecideCnt,
			String createDt, String updateDt) {
		super();
		this.seq = seq;
		this.stateDt = stateDt;
		this.stateTime = stateTime;
		this.deathCnt = deathCnt;
		this.decideCnt = decideCnt;
		this.dailyDecideCnt = dailyDecideCnt;
		this.createDt = createDt;
		this.updateDt = updateDt;
	}



	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getStateDt() {
		return stateDt;
	}

	public void setStateDt(String stateDt) {
		this.stateDt = stateDt;
	}

	public String getStateTime() {
		return stateTime;
	}

	public void setStateTime(String stateTime) {
		this.stateTime = stateTime;
	}

	public int getDeathCnt() {
		return deathCnt;
	}

	public void setDeathCnt(int deathCnt) {
		this.deathCnt = deathCnt;
	}

	public int getDecideCnt() {
		return decideCnt;
	}

	public void setDecideCnt(int decideCnt) {
		this.decideCnt = decideCnt;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	
	public int getDailyDecideCnt() {
		return dailyDecideCnt;
	}



	public void setDailyDecideCnt(int dailyDecideCnt) {
		this.dailyDecideCnt = dailyDecideCnt;
	}



	@Override
	public String toString() {
		return "Covid [seq=" + seq + ", stateDt=" + stateDt + ", stateTime=" + stateTime + ", deathCnt=" + deathCnt
				+ ", decideCnt=" + decideCnt + ", dailyDecideCnt=" + dailyDecideCnt + ", createDt=" + createDt
				+ ", updateDt=" + updateDt + "]";
	}



	
	
	
	
	
}
