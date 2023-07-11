package com.skillstorm.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.LeadActress;

// Repository tells this file that it should be an injectable repo for this particular type
@Repository
// extending CrudRepository<Object Type, Primary Key Type> gives all the basic CRUD functionality
public interface LeadActressRepository extends CrudRepository<LeadActress, Integer> {

}
