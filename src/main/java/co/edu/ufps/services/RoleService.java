package co.edu.ufps.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Position;
import co.edu.ufps.repositories.PositionRepository;

@Service
public class RoleService {
	
	 @Autowired
	 private PositionRepository positionRepository;

	    public Position getPositionById(Integer id) {
	        Optional<Position> positionOptional = positionRepository.findById(id);
	        return positionOptional.orElse(null);
	    }

}
