package net.javaguides.springboot.entity;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Employees")
public class Employee implements Comparable<Employee> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name")
	private String Name;
	
	@Column(name = "salary")
	private int Salary;
	
	@Column(name = "designation")
	private String Designation;
	
	public Employee() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setFirstName(String Name) {
		this.Name = Name;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int Salary) {
		this.Salary = Salary;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String Designation) {
		this.Designation = Designation;
	}

	@Override
	public int compareTo(Employee o) {
		if(this.getSalary() == o.getSalary()) {
			return this.getName().compareTo(o.getName());
		}
		return -(this.getSalary() - o.getSalary());
	}

	

	
	
}
