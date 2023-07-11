package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.LeadActor;

@Repository
public interface LeadActorRepository extends CrudRepository<LeadActor, Integer> {

}
