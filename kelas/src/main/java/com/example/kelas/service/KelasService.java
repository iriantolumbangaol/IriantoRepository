package com.example.kelas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kelas.model.KelasModel;
import com.example.kelas.repository.KelasRepository;

@Service
@Transactional
public class KelasService {
	
	@Autowired
	private KelasRepository kelasRepository;
	
	public void create(KelasModel kelasModel) {
		this.kelasRepository.save(kelasModel);
	}
	
	public List<KelasModel> readData(){
		return this.kelasRepository.findAll();
	}
	
	public void update(KelasModel kelasModel) {
		this.kelasRepository.getOne(id);
	}

}
