package com.unisangil.resultados.controller.dto;

import java.util.ArrayList;
import java.util.List;

import com.unisangil.resultados.service.dto.MenuDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDetailLoginDTO extends ResponseDTO {

	private static final long serialVersionUID = 1L;
	
	private Long idUser;
	private String token;    
    private String userName;
    private String documento;
    private String defaultUrl;
    private List<MenuDTO> menu = new ArrayList<>();
    
    

}
