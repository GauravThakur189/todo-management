package net.javaproject.todo._management.service.impl;

import lombok.AllArgsConstructor;
import net.javaproject.todo._management.dto.TodoDto;
import net.javaproject.todo._management.entity.Todo;
import net.javaproject.todo._management.repository.TodoRepository;
import net.javaproject.todo._management.service.TodoService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {


    private TodoRepository todoRepository;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //converting tododto to todo1 object
        Todo todo = new Todo();
        todo.setId(todoDto.getId());
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.isCompleted());
        todoRepository.save(todo);

        // converting saved todo1 to tododto object
        TodoDto savedtodo = new TodoDto();
        savedtodo.setId(todo.getId());
        savedtodo.setTitle(todo.getTitle());
        savedtodo.setDescription(todo.getDescription());
        savedtodo.setCompleted(todo.isCompleted());

         return  savedtodo;

    }
}
