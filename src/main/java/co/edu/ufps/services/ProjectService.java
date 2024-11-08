package co.edu.ufps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Project;
import co.edu.ufps.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	 @Autowired
	 private ProjectRepository projectRepository;

	 public Project createProject(Project project) {
		 return projectRepository.save(project);
	 }

}
