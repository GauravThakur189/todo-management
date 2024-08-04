package net.javaproject.todo._management.repository;

import net.javaproject.todo._management.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}
