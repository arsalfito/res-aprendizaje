package com.unisangil.resultados.controller.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private boolean success = true;
    private String message;

}
