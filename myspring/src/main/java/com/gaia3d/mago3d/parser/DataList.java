package com.gaia3d.mago3d.parser;

import java.util.ArrayList;
import java.util.List;

public class DataList {
	private List<Data> dataList  = new ArrayList<>();

	public List<Data> getDataList() {
		return dataList;
	}

	public void setDataList(List<Data> dataList) {
		this.dataList = dataList;
	}

	@Override
	public String toString() {
		return "DataList [dataList=" + dataList + "]";
	}
	
	
}
