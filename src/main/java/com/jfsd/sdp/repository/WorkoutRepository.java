package com.jfsd.sdp.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.jfsd.sdp.model.Workout;



@Repository
public interface WorkoutRepository extends CrudRepository<Workout,Integer>
{
  
}