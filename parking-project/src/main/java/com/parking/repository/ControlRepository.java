package com.parking.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parking.entity.ControlEntity;

public interface ControlRepository extends JpaRepository<ControlEntity, String> {

	//입차 출차 구분
	@Query(value = "SELECT ce FROM ControlEntity ce WHERE ce.carNo = :carNo AND ce.exitTime IS null")
	ControlEntity findControlEntityByCarNoAndNoExit(@Param("carNo") String carNo);

	//출차
	@Transactional
	@Modifying
	@Query(value = "UPDATE ControlEntity ce SET ce.exitTime = LOCALTIMESTAMP WHERE ce.carNo = :carNo AND ce.exitTime IS null")
	void exitControl(@Param("carNo") String carNo);
}
