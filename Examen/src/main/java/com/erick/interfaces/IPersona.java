package com.erick.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.erick.models.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona,Integer>  {

}
