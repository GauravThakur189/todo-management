package net.javaproject.todo._management.service;

import net.javaproject.todo._management.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo (TodoDto todoDto);
    TodoDto getTodo (Long id);

   List<TodoDto> getAllTodo();
   TodoDto updateTodo (TodoDto todoDto,Long id);

   void deleteTodo(Long id);
}
