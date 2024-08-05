package net.javaproject.todo._management.service;

import net.javaproject.todo._management.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo (TodoDto todoDto);
    TodoDto getTodo (Long id);

   // List<TodoDto> getAllTodo();
}
