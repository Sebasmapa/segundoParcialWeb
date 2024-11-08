package co.edu.ufps.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="birthdate")
	private Date birthdate;
	@Column(name="entry_date")
	private Date entry_date;
	
	@ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;
	
	 @ManyToOne
	 @JoinColumn(name = "pos_id")
	 private Position position;
	 
	 @ManyToMany
	 @JoinTable(
	        name = "visit", 
	        joinColumns = @JoinColumn(name = "employee_id"),
	        inverseJoinColumns = @JoinColumn(name = "department_id")
	    )
	    private List<Department> departments;
	 
}
