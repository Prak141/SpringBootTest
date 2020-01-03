package com.prakash.springboot.test.SprinBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

//@Author Prakash Chidambaram
@Service
public class TodoHardCodedService {
	
	private static List<Todo> todos = new ArrayList();
	private static int idCounter=0;
	
	static {
		todos.add(new Todo(++idCounter,"Learn AngularJS",false,new Date()));
		todos.add(new Todo(++idCounter,"Learn Spring",false,new Date()));
		todos.add(new Todo(++idCounter,"Learn SpringBoot",false,new Date()));
		todos.add(new Todo(++idCounter,"Become fullStackDeveloper",false,new Date()));	
	}
	
	public List<Todo> findTodos(){
		return todos;
	}

	public Todo DeleteTodo(int id, String username){
		Todo todo = findbyId(id);
		if(todo==null) {
			return null;
		}
		todos.remove(todo);
		return todo;
	}

	public Todo findbyId(int id) {
		for(Todo todo:todos) {
			if(todo.getId()==id) {
				return todo;
			}
		}
		return null;
	}
	
	public List<Todo> UpdateTodo(String name, Todo deletetodo, Todo todo){
			todos.remove(deletetodo);
			todos.add(todo);
			return todos;
	}
	
	
	
}
