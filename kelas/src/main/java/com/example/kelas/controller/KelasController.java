package com.example.kelas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.kelas.model.KelasModel;
import com.example.kelas.service.KelasService;

@Controller
public class KelasController {

	@Autowired
	private KelasService kelasService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<KelasModel> listKelas = kelasService.readData();
		model.addAttribute("listKelas", listKelas);
		return "index";
	}

	@RequestMapping("/new")
	public String ShowNewKelasForm(Model model) {
		KelasModel kelasModel = new KelasModel();
		model.addAttribute("kelasModel", kelasModel);
		return "new_kelas";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveKelas(@ModelAttribute("kelasModel")KelasModel kelasModel) {
		kelasService.create(kelasModel);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{kodeKelas}")
	public ModelAndView ShowEditKelasForm(@PathVariable(name = "kodeKelas") String kodeKelas) {
		ModelAndView mav = new ModelAndView("edit_kelas");
		KelasModel kelasModel = kelasService.get(kodeKelas);
		mav.addObject("kelasModel", kelasModel);
		
		return mav;
	}
	
	@RequestMapping("/delete/{kodeKelas}")
	public String deleteKelas(@PathVariable(name = "kodeKelas") String kodeKelas) {
		kelasService.delete(kodeKelas);
		
		return "redirect:/";
	}
}
