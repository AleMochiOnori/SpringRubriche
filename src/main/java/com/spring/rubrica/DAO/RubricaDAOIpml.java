package com.spring.rubrica.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.rubrica.entity.RubricaEntity;


@Repository
public class RubricaDAOIpml implements RubricaDAO {
	private Map<Integer, RubricaEntity> mappa = new HashMap<>();


	public boolean insert(RubricaEntity rub) {
		if(mappa.containsKey(rub.getId()))
			return false;
		
		mappa.put(rub.getId(), rub);
		return true;

	}
		public ArrayList<RubricaEntity> selectAll(){
			return new ArrayList<RubricaEntity>(mappa.values());
	}

		public RubricaEntity selectById(Integer idUtente) {
		return mappa.get(idUtente);
	}




		public boolean delete(Integer idUtente) {
		RubricaEntity utente = mappa.remove(idUtente);
		return utente!=null;
	}


}
