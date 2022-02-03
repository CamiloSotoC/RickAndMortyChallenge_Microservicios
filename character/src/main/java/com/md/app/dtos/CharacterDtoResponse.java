package com.md.app.dtos;

import java.util.ArrayList;

import lombok.Data;

@Data
public class CharacterDtoResponse {
	
	private Integer id;	
	private String name;
	private String status;
	private String species;
	private String type;	
	private LocationDtoResponse origin;
	private LocationDtoResponse location;
	private ArrayList<String> episode;

}
