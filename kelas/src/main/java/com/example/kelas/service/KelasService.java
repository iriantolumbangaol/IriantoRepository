package com.example.kelas.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.RecordTypeNotSupportedException;
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
	
	public KelasModel get(String kodeKelas) {
		return kelasRepository.findById(kodeKelas).get();
	}
	
	public void delete(String kodeKelas) {
		kelasRepository.deleteById(kodeKelas);
	}
	
	public void update(KelasModel kelasModel) {
		this.kelasRepository.save(kelasModel);
	}
	
	
	

}
