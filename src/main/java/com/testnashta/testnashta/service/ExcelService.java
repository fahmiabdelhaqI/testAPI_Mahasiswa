package com.testnashta.testnashta.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.testnashta.testnashta.model.mahasiswa;
import com.testnashta.testnashta.repository.mahasiswaRepository;

@Service
public class ExcelService {

	  @Autowired
	  mahasiswaRepository repository;

	  public void save(MultipartFile file) {
	    try {
	      List<mahasiswa> mahasiswas = ExcelHelper.excelToMahasiswa(file.getInputStream());
	      repository.saveAll(mahasiswas);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }

	  public List<mahasiswa> getAllMahasiswas() {
	    return (List<mahasiswa>) repository.findAll();
	  }
	  
	  public List<mahasiswa> ReadDataFromExcel(MultipartFile excelPath) throws EncryptedDocumentException, 
	  	InvalidFormatException, IOException
	  {
		  	XSSFWorkbook workbook = new XSSFWorkbook(excelPath.getInputStream());
			// Retrieving the number of sheets in the Workbook
	        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
	        System.out.println("Retrieving Sheets using for-each loop");
	        for(Sheet sheet: workbook) {
	            System.out.println("=> " + sheet.getSheetName());
	            
	            DataFormatter dataFormatter = new DataFormatter();
	            for (Row row: sheet) {
	            	
//	            	DataFormatter formatter = new DataFormatter();
//	            	String str = formatter.formatCellValue(row.getCell(0));
//	            	double dnum = Double.parseDouble(str);
//	            	System.out.println("In formated Cell Value--" + dnum);
	            	
	            	double idmhs = row.getCell(0).getNumericCellValue();
	            	String nama = row.getCell(1).getStringCellValue();
	            	String alamat = row.getCell(2).getStringCellValue();
	            	
	            	  
	            	mahasiswa mhs = new mahasiswa();
	            	mhs.setIdmhs((long)idmhs);
	            	mhs.setNama(nama);
	            	mhs.setAlamat(alamat);
	            	
	            	
	            	repository.save(mhs);
	            	
	                System.out.println(row.getCell(0).getNumericCellValue());
	                System.out.println(row.getCell(1).getStringCellValue());
	                System.out.println(row.getCell(2).getStringCellValue());
	              
	            }
	        }
			return null;
	  }
}
