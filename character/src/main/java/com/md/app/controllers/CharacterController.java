package com.md.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.dtos.ErrorDtoResponse;
import com.md.app.interfaces.CharacterServiceInterface;
import com.md.app.models.Character;

@RestController
@RequestMapping("/character")
public class CharacterController {
	
	@Autowired
	private CharacterServiceInterface service;
				
	@GetMapping("/{id}")	
	public ResponseEntity<?> findById(@Valid @PathVariable Integer id) {		
		CharacterDtoResponse result = service.findByIdDto(id);
		if(result == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDtoResponse("Character not found"));		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	@GetMapping("/raw/{id}")	
	public ResponseEntity<?> findByIdRaw(@Valid @PathVariable Integer id) {		
		Character result = service.findByIdRaw(id);
		if(result == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDtoResponse("Character not found"));		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}

}
