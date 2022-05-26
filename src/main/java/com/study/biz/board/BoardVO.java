package com.study.biz.board;

import java.sql.Date;

import lombok.Data;

//Board VO(Value Object)
@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
	private String select;
	private String searchContent;
}
