package com.erick.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.interfaces.IPersona;
import com.erick.interfaces.iservice.IpersonaService;
import com.erick.models.Persona;

@Service
public class PersonaService implements IpersonaService{
	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listar() {
		
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return data.findById(id);

	}

	@Override
	public int guardar(Persona per) {
		int res=0;
		Persona cliente=data.save(per);
		if(!cliente.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);		
	}

}
