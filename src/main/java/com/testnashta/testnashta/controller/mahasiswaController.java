package com.testnashta.testnashta.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.testnashta.testnashta.dto.ResponseJson;
import com.testnashta.testnashta.enumeration.responseCodes;
import com.testnashta.testnashta.model.mahasiswa;
import com.testnashta.testnashta.repository.mahasiswaRepository;
import com.testnashta.testnashta.service.ExcelService;
import com.testnashta.testnashta.service.mahasiswaService;

@RestController

@RequestMapping("/api/v2")
public class mahasiswaController {
	@Autowired
	mahasiswaRepository MahasiswaRepository;
	
	@Autowired
	mahasiswaService MahasiswaService;
	
	@Autowired
	ExcelService excelService;
	
	@GetMapping("/getAll")
	public List<mahasiswa> getAll(){
		return (List<mahasiswa>) MahasiswaRepository.findAll();
	}
	
	@PostMapping("/Upload")
	public ResponseEntity<ResponseJson> getExcelToDB(@RequestParam("file") MultipartFile reapExcelDataFile)
	throws IOException{
		try {
			 excelService.ReadDataFromExcel(reapExcelDataFile);
		        return ResponseEntity.status(HttpStatus.OK).body(new ResponseJson(responseCodes.SUCCESS, "OK"));
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseJson(responseCodes.OTHER, e.getMessage()));
		}
	}
}
