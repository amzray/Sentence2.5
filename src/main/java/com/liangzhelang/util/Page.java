package com.liangzhelang.util;

import java.util.List;

import org.springframework.stereotype.Component;

public class Page<T> {
	//页码选单包含的页码数
	private static Integer pageListSize = 5;
	//包含的数据记录
	private List<T> list;
	//当前页码
	private Integer currPage;
	//每页包含的记录数
	private Integer pageSize;
	//需要分页表示的总的数据库记录数
	private Integer totalRecord;
	
	//总页数=总记录数/每页记录数，向上取整
	private Integer totalPage;
	//数据库中的起始记录码（和resultset类似是指向前一位）=(当前记录数 - 1) * 每页记录数
	private Integer startRow;
	//页码选单的起始页码
	private Integer startPage;
	//页码选单的结束页码
	private Integer endPage;
	
	public Page (Integer currPage, Integer pageSize, Integer totalRecord) {
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		
		//总页数
		if(totalRecord % pageSize == 0) {
			this.totalPage = totalRecord / pageSize;
		}else {
			this.totalPage = totalRecord / pageSize + 1;
			//修正尾页大小
			if(currPage==totalPage) {
				this.pageSize = totalRecord % pageSize;
			}
		}
		
		//开始记录码
		this.startRow = (currPage - 1) * pageSize;
		//开始页码和结束页码
		//总页数小于页码选单的大小
		if(totalPage <= pageListSize) {
			this.startPage = 1;
			this.endPage = totalPage;
		}else{//使开始页码和结束页码在不超出边界的情况下，保持当前页码是开始页码和结束页码的中位数
			this.startPage = currPage - (pageListSize/2);
			this.endPage = currPage + (pageListSize/2); 
			//超出边界，修正
			if(startPage<=0) {
				startPage = 1;
				this.endPage = pageListSize;
			}
			if(endPage >totalPage) {
				endPage = totalPage;
				startPage = endPage - pageListSize;
			}
		}
	}

	public List<T> getList() {
		return list;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public Integer getPageListSize() {
		return pageListSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public static void setPageListSize(Integer pageListSize) {
		Page.pageListSize = pageListSize;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	
	
	
}
