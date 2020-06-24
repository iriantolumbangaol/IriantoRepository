package com.example.kelas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.kelas.model.KelasModel;

public interface KelasRepository extends JpaRepository<KelasModel, String> {
	/*
	@Query("select k from kelasModel k")
	List<KelasModel> readData();
	
	@Query("select k from kelasModel k where namaKelas like %?1%")
	List<KelasModel> cariNama (String namaKelas);
*/

}
