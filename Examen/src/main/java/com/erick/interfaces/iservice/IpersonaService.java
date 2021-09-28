package com.erick.interfaces.iservice;

import java.util.List;
import java.util.Optional;
import com.erick.models.Persona;

public interface IpersonaService {
	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int guardar(Persona per);
	public void eliminar( int id); 
}
