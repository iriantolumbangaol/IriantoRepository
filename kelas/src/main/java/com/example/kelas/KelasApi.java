package com.example.kelas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.kelas.model.KelasModel;
import com.example.kelas.service.KelasService;

@RestController
@RequestMapping(value="/api/kelas")
public class KelasApi {
	
	@Autowired
	private KelasService kelasService;
	
	@PostMapping("/post")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Map<String, Object> postMapping(@RequestBody KelasModel kelasModel){
		
		this.kelasService.create(kelasModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Success", Boolean.TRUE);
		map.put("Pesan", "Data Sudah Masuk");
		
		return map;
	}
	
	@GetMapping("/get")
	@ResponseStatus(code = HttpStatus.OK)
	public List<KelasModel> GetMapping(){
		List<KelasModel> kelasModelList = new ArrayList<KelasModel>();
		kelasModelList = this.kelasService.readData();
		
		return kelasModelList;
	}
}
