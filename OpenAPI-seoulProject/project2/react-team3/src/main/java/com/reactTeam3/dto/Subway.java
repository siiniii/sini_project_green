package com.reactTeam3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				// 필드에 getter, setter를 만드세요
@NoArgsConstructor 	// 전달인자 없는 생성자 메서드 만드세요
@AllArgsConstructor	// 모든 전달인자를 사용하는 생성자 메서드 만드세요
public class Subway {
	
	private String station;
	private String line;
	private int start;
	private int end;

}
