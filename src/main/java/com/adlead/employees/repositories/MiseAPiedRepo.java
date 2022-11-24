package com.adlead.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adlead.employees.models.MiseAPied;

@Repository
public interface MiseAPiedRepo extends JpaRepository<MiseAPied, Long>{
	
	@Query("select m from MiseAPied m where m.date>=:de and m.date<=:jusqua")
	public List<MiseAPied> findAllMiseAPiedsByDate(
			@Param("de") String de, 
			@Param("jusqua") String jusqua);

}
