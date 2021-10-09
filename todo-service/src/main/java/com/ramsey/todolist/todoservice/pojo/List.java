package com.ramsey.todolist.todoservice.pojo;

import lombok.*;

@With
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class List {
	
	private Long id;
	private String name;
	private Long userId;
	
}
