package net.javaproject.todo._management.repository;

import net.javaproject.todo._management.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
