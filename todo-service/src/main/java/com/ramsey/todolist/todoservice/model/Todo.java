package com.ramsey.todolist.todoservice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@With
@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Pattern(regexp = "^[A-z\\d\\s!@#$%^&*()_+=./|`~'\"}{-]{3,}$")
	private String name;
	private Boolean finished;
	private Long listId;
	
	{
		
		finished = false;
		
	}
	
}
