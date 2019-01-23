package com.mastek.fullstackassignment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ParticipantJPARepository extends CrudRepository<Participant, Integer>{

}
