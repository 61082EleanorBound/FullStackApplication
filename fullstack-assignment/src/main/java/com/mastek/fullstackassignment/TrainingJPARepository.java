package com.mastek.fullstackassignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component//interface marked as BEAN
public interface TrainingJPARepository extends CrudRepository<Training, Integer>{
	// 2 inputs = Entity Class and Primary Key Data Type
}
