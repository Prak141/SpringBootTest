package com.prakash.springboot.test.SprinBootTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Author Prakash Chidambaram

@RestController
public class TodoResource {
	
	@Autowired
	private TodoHardCodedService todoservice;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/{name}/gettodos")
	public List<Todo> Todolist(@PathVariable String name){
		return todoservice.findTodos();
	}
	
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping("/{name}/deletetodo/{id}")
	public ResponseEntity<Void> Todolist(@PathVariable String name,@PathVariable int id){
		Todo todo = todoservice.DeleteTodo(id, name);
		if(todo!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping("/{name}/updatetodo")
	public ResponseEntity<List<Todo>> Todolist(@PathVariable String name,@RequestBody Todo todo){
		Todo foundtodo = todoservice.findbyId(todo.getId());
		if(foundtodo==null) {
			return new ResponseEntity<List<Todo>>(todoservice.findTodos(),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<List<Todo>>(todoservice.UpdateTodo(name, foundtodo,todo),HttpStatus.OK);
		}		
	}

}
