package com.lottecard.myd.test.model.vo;


import java.util.Set;

import com.lottecard.myd.cmn.model.vo.AbstractEntity;


public class COMMONCodeEntity extends AbstractEntity {

	private String groupCode;
	private String code;
	private String codeName;
	private String usageStatus;
	private String createDt;
	private String createId;
	private String updateDt;
	private String updateId;

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public void setUsageStatus(String usageStatus) {
		this.usageStatus = usageStatus;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public String getCode() {
		return code;
	}

	public String getCodeName() {
		return codeName;
	}

	public String getUsageStatus() {
		return usageStatus;
	}

	public String getCreateDt() {
		return createDt;
	}

	public String getCreateId() {
		return createId;
	}

	public String getUpdateDt() {
		return updateDt;
	}

	public String getUpdateId() {
		return updateId;
	}

	@Override
	public void setAssignParameters(Set<String> assignParameters) {
		// TODO Auto-generated method stub
		super.setAssignParameters(assignParameters);
	}

	@Override
	public String toString() {
		return "COMMONCodeVO [groupCode=" + groupCode + ", code=" + code + ", codeName=" + codeName + ", usageStatus="
				+ usageStatus + ", createDt=" + createDt + ", createId=" + createId + ", updateDt=" + updateDt
				+ ", updateId=" + updateId + "]";
	}

}
