package com.testnashta.testnashta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testnashta.testnashta.model.matakuliah;


@Repository
public interface matakuliahRepository extends JpaRepository<matakuliah, Long>{

}
