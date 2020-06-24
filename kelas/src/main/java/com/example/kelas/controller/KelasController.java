package com.example.kelas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kelas.model.KelasModel;
import com.example.kelas.service.KelasService;

@Controller
public class KelasController {
	
	@Autowired
	private KelasService kelasService;
	
	@RequestMapping("/")
	public String Insert() {
		String home = "insert";
		return home;
	}
	
	@RequestMapping("/kelas/create")
	public String kelasCreate(HttpServletRequest request, Model model) {
		String kodeKelas = request.getParameter("kodeKelas");
		String namaKelas = request.getParameter("namaKelas");
		int tingkat = Integer.parseInt(request.getParameter("tingkat"));
		
		KelasModel kelasModel = new KelasModel();
		kelasModel.setKodeKelas(kodeKelas);
		kelasModel.setNamaKelas(namaKelas);
		kelasModel.setTingkat(tingkat);
		
		this.kelasService.create(kelasModel);
		
		this.ListKelas(model);
		
		String home = "list";
		
		return home;
	}
	
	@RequestMapping("/kelas/list")
	public void ListKelas(Model model) {
		List<KelasModel> kelasModelList = new ArrayList<KelasModel>();
		kelasModelList = kelasService.readData();
		
		
		model.addAttribute("kelasModelList", kelasModelList);
	}

}
