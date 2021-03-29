package com.testnashta.testnashta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testnashta.testnashta.model.mahasiswa;
import com.testnashta.testnashta.repository.mahasiswaRepository;



@Service
public class mahasiswaServiceImpl implements mahasiswaService {

	@Autowired
	private mahasiswaRepository MahasiswaRepo;
	
	@Override
	public mahasiswa save(mahasiswa Mahasiswa) {
		return MahasiswaRepo.save(Mahasiswa);
	}
}
