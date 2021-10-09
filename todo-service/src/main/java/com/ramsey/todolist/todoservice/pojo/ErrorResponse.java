package com.ramsey.todolist.todoservice.pojo;

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
