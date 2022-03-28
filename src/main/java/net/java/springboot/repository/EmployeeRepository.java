package net.java.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.java.springboot.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	
}
