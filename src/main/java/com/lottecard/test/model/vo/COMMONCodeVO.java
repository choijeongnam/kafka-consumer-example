package com.lottecard.test.model.vo;

import org.apache.ibatis.type.Alias;

import com.lottecard.cmn.model.vo.AbstractVO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class COMMONCodeVO extends AbstractVO  {

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
}
