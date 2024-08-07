package net.javaproject.todo._management.controller;


import lombok.AllArgsConstructor;
import net.javaproject.todo._management.dto.TodoDto;
import net.javaproject.todo._management.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id){
        TodoDto getTodo = todoService.getTodo(id);
        return new ResponseEntity<>(getTodo,HttpStatus.OK);

    }

    @GetMapping("get")
    public ResponseEntity<List<TodoDto>> getAll(){
            List<TodoDto> list =   todoService.getAllTodo();
            return  new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable Long id){
        TodoDto updateTodo =   todoService.updateTodo(todoDto,id);
        return new ResponseEntity<>(updateTodo,HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public  ResponseEntity<String>  deleteTodo(@PathVariable Long id){
         todoService.deleteTodo(id);
         return new ResponseEntity<>("Todo deleted successfully",HttpStatus.OK);
    }

}
