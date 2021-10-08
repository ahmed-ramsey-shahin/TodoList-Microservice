package com.ramsey.todolist.listservice.pojo;

import lombok.*;

@With
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	
	private Integer status;
	private String message;
	
}
