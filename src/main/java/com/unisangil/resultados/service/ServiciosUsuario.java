package com.unisangil.resultados.service;

import com.unisangil.resultados.controller.dto.LoginDTO;
import com.unisangil.resultados.controller.dto.ResponseDetailLoginDTO;
import com.unisangil.resultados.model.Menu;
import com.unisangil.resultados.model.Rol;
import com.unisangil.resultados.model.Usuario;
import com.unisangil.resultados.repository.RepositorioUsuario;
import com.unisangil.resultados.service.dto.MenuDTO;
import com.unisangil.resultados.util.MessageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosUsuario extends ServiciosBase<Usuario, Long>{

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	
	public ResponseDetailLoginDTO login(LoginDTO loginDTO) {
		ResponseDetailLoginDTO response = new ResponseDetailLoginDTO();
		Optional<Usuario> optUsuario = this.repositorioUsuario.getByUserName(loginDTO.getUserName(), loginDTO.getPassword());
		if(optUsuario.isEmpty()) {
			response.setSuccess(false);
            response.setMessage(MessageUtil.USER_INVALID);
            return response;
		}
		
		Usuario usuario = optUsuario.get();
		response.setIdUser(usuario.getId());
		response.setUserName(usuario.getNombre());
		
		List<Rol> roles = usuario.getRoles();
		if(roles!=null && !roles.isEmpty()) {
			List<MenuDTO> menuDTO = new ArrayList<>();
			for(Rol r: roles) {
				List<Menu> menu = r.getMenu();
				if(menu!=null && !menu.isEmpty()) {
					for(Menu m: menu)
						menuDTO.add(new MenuDTO(m.getId(), m.getTitle(), m.getRoute()));
				}
			}
			response.setMenu(menuDTO);
		}
		
		return response;
	}
}
