package com.jfsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jfsd.sdp.model.Nutritionist;

import jakarta.transaction.Transactional;


@Repository
public interface NutritionistRepository  extends JpaRepository<Nutritionist,Integer>
{
@Query("select n from Nutritionist n where n.email=?1 and n.password=?2")
	
	public Nutritionist checknutrilogin(String email,String password);

@Query("update Nutritionist n set n.qualifications=?1 where n.id=?2")
@Modifying  // DML Operation
@Transactional  // to enable auto commit
public int updatenutriqualifications(String qualifications,int id);



}
