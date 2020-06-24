package com.example.kelas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kelas")
public class KelasModel {
	
	@Id
	@Column(name="kodekelas")
	private String kodeKelas;
	
	@Column(name="namakelas")
	private String namaKelas;
	
	@Column(name="tingkat")
	private int tingkat;

	public String getKodeKelas() {
		return kodeKelas;
	}

	public void setKodeKelas(String kodeKelas) {
		this.kodeKelas = kodeKelas;
	}

	public String getNamaKelas() {
		return namaKelas;
	}

	public void setNamaKelas(String namaKelas) {
		this.namaKelas = namaKelas;
	}

	public int getTingkat() {
		return tingkat;
	}

	public void setTingkat(int tingkat) {
		this.tingkat = tingkat;
	}

}
