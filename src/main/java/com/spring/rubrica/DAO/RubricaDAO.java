package com.spring.rubrica.DAO;

import java.util.ArrayList;

import com.spring.rubrica.entity.ContattoEntity;
import com.spring.rubrica.entity.RubricaEntity;

public interface RubricaDAO {
	public boolean insert(RubricaEntity rub);
	public ArrayList<RubricaEntity> selectAll();
	public RubricaEntity selectById(Integer idUtente);
	public boolean delete(Integer idUtente);
	public boolean addContattoToRubrica(Integer idRubrica, ContattoEntity contatto);
	public ContattoEntity selectContattoById(Integer idRubrica, int idContatto);
}
