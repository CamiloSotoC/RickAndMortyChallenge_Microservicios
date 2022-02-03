package com.md.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.app.dtos.CharacterDtoResponse;
import com.md.app.interfaces.CharacterRepositoryInterface;
import com.md.app.interfaces.CharacterServiceInterface;
import com.md.app.models.Character;

@Service
public class CharacterService implements CharacterServiceInterface{
	
	@Autowired
	private CharacterRepositoryInterface repository;	
	@Autowired
	private ModelMapper modelMapper;
	
	public Character findByIdRaw(Integer id) {		
		Character result = repository.findById(id);
		return result;
	}
	
	public CharacterDtoResponse findByIdDto(Integer id) {
		Character character = repository.findById(id);
		if (character == null)
			return null;
		CharacterDtoResponse characterDto = modelMapper.map(character, CharacterDtoResponse.class);		
		return characterDto;
	}
	
}
