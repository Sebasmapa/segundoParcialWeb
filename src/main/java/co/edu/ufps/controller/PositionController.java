package co.edu.ufps.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.entities.Position;
import co.edu.ufps.services.PositionService;

@RestController
@RequestMapping("/position")
public class PositionController {
	
	@Autowired
	private PositionService positionService;

	@GetMapping("/{id}")
    public ResponseEntity<Position> getPosition(@PathVariable Integer id) {
        Position position = positionService.getPositionById(id);
        if (position != null) {
            return new ResponseEntity<>(position, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

	}
}
