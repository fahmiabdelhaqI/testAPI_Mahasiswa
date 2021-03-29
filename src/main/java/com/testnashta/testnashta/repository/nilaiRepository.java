package com.testnashta.testnashta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testnashta.testnashta.model.nilai;


@Repository
public interface nilaiRepository extends JpaRepository<nilai, Long>{
nilai findOneByIdmhsAndIdmatkul(long idmhs, long idmatkul);
	
	@Query(value = "SELECT AVG(nilai) FROM test_nashta.nilai WHERE idmhs = ?1" , nativeQuery = true)long getRatarata(long idmhs);

}
