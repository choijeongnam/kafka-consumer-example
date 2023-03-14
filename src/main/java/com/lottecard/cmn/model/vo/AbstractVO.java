package com.lottecard.cmn.model.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AbstractVO implements Serializable {
	private static final long serialVersionUID = 1028061241484497901L;

	@JsonIgnore
	protected Set<String> assignParameters = new HashSet<String>();

	public Set<String> getAssignParameters() {
		return assignParameters;
	}

	public void setAssignParameters(Set<String> assignParameters) {
		this.assignParameters = assignParameters;
	}

	public void addAssignParameters(String parameter){
		this.assignParameters.add(parameter);
	}

	public void removeAssignParameters(String parameter){
		this.assignParameters.remove(parameter);
	}
}
