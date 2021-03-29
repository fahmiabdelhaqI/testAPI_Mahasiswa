package com.testnashta.testnashta.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "mahasiswa")
public class mahasiswa {
	@Id
	private long idmhs;
	private String nama;
	private String alamat;
	
	@Override
	public String toString() {
		return "Mahasiswa [idmhs=" + idmhs + ", nama=" + nama + ", alamat=" + alamat  + "]";
	}
}
