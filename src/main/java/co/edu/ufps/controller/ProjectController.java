package co.edu.ufps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Project;
import co.edu.ufps.services.ProjectService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/position")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	 @PostMapping
	    public ResponseEntity<Project> createProject(@RequestBody Project project) {
	        Project createdProject = projectService.createProject(project);
	        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
	    }


}
