package net.javaproject.todo._management.service.impl;

import lombok.AllArgsConstructor;
import net.javaproject.todo._management.dto.TodoDto;
import net.javaproject.todo._management.entity.Todo;
import net.javaproject.todo._management.exception.ResourceNotFoundException;
import net.javaproject.todo._management.repository.TodoRepository;
import net.javaproject.todo._management.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {


    private TodoRepository todoRepository;

    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        //converting tododto to todo1 object
//        Todo todo = new Todo();
//        todo.setId(todoDto.getId());
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());
        Todo todo = modelMapper.map(todoDto,Todo.class);
       Todo savedTodo = todoRepository.save(todo);

        // converting saved todo1 to tododto object
//        TodoDto savedtodo = new TodoDto();
//        savedtodo.setId(todo.getId());
//        savedtodo.setTitle(todo.getTitle());
//        savedtodo.setDescription(todo.getDescription());
//        savedtodo.setCompleted(todo.isCompleted());

        TodoDto savedtodo = modelMapper.map(savedTodo,TodoDto.class);

         return  savedtodo;

    }

    @Override
    public TodoDto getTodo(Long id) {
        Todo getTodo = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("todo not found with given id " +id));
       return modelMapper.map(getTodo,TodoDto.class);

    }

    @Override
    public List<TodoDto> getAllTodo() {
       List<Todo> list =   todoRepository.findAll();
       List<TodoDto> getList = list.stream().map((todo -> modelMapper.map(todo,TodoDto.class)))
               .collect(Collectors.toList());
       return getList;
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto, Long id) {
     Todo todo =    todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo Not Found"+ id));
     todo.setTitle(todoDto.getTitle());
     todo.setDescription(todoDto.getDescription());
     todo.setCompleted(todoDto.isCompleted());
      Todo updatedTodo =    todoRepository.save(todo);
      return modelMapper.map(updatedTodo,TodoDto.class);
    }

    @Override
    public void deleteTodo(Long id) {
    // Todo todo =   todoRepository.findById(id).get();
        todoRepository.deleteById(id);

    }

    @Override
    public TodoDto completedTodo(Long id) {
      Todo todo =  todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Todo not found "+ id));
      todo.setCompleted(Boolean.TRUE);
    Todo completedTodo =   todoRepository.save(todo);
    return modelMapper.map(completedTodo,TodoDto.class);
    }

    @Override
    public TodoDto inCompletedTodo(Long id) {
      Todo todo =  todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(("Todo not found "+id)));
      todo.setCompleted(Boolean.FALSE);
    Todo inCompleted  =   todoRepository.save(todo);
    return modelMapper.map(inCompleted, TodoDto.class);
    }
}
