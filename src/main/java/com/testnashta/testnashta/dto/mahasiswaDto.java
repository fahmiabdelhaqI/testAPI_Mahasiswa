package com.testnashta.testnashta.dto;

public class mahasiswaDto {
	private long idMahasiswa;
	private String namaMahaiswa;
	
	private String namaMatakuliah;
	private int nilai;
	public long getIdMahasiswa() {
		return idMahasiswa;
	}
	public void setIdMahasiswa(long idMahasiswa) {
		this.idMahasiswa = idMahasiswa;
	}
	public String getNamaMahaiswa() {
		return namaMahaiswa;
	}
	public void setNamaMahaiswa(String namaMahaiswa) {
		this.namaMahaiswa = namaMahaiswa;
	}
	public String getNamaMatakuliah() {
		return namaMatakuliah;
	}
	public void setNamaMatakuliah(String namaMatakuliah) {
		this.namaMatakuliah = namaMatakuliah;
	}
	public int getNilai() {
		return nilai;
	}
	public void setNilai(int nilai) {
		this.nilai = nilai;
	}
	
	public String getNamaMatkul() {
		return namaMatakuliah;
	}
	public void setNamaMatkul(String namaMatakuliah) {
		this.namaMatakuliah = namaMatakuliah;
	}
	public int getNilaiMhs() {
		return nilai;
	}
	public void setNilaiMhs(int nilai) {
		this.nilai = nilai;
	}
}
