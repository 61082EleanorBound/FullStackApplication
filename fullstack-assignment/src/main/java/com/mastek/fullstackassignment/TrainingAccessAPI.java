package com.mastek.fullstackassignment;

import java.util.Set;

import javax.transaction.Transactional;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

//JAX-RS Restful API 
@Component// Spring framework will autodetect this classes for dependency injection when annotation-based configuration and class path scanning is used
@Path("/trainings/")
public class TrainingAccessAPI {
	
	TrainingJPARepository repository;
	ParticipantJPARepository parrepository;

	public TrainingJPARepository getRepository() {
		return repository;
	}
	
	@Autowired //declare the property for Repository
	public void setRepository(TrainingJPARepository repository) {
		this.repository = repository;
	}
	
	public ParticipantJPARepository getParrepository() {
		return parrepository;
	}
	@Autowired
	public void setParrepository(ParticipantJPARepository parrepository) {
		this.parrepository = parrepository;
	}
	
	@Path("/list")
	@GET//HTTP method = and use path "/list" to call this HTTP method
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})//JSON will be default format when fetching data, if not JSON will give XML
	public Iterable<Training> listTrainings(){
		return getRepository().findAll();
	}
		
	@POST
	@Path("/register")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})//specify which MIME media types of representations a resource can accept, or consume, from the client
	public Training addTraining(@BeanParam Training newTraining) {
		getRepository().save(newTraining);

		return newTraining;
	}
	
	
	@DELETE
	@Path("/delete")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Training deleteTraining(int courseId) {
		Training deleteTraining = getRepository().findById(courseId).get();
		getRepository().delete(deleteTraining);
		return deleteTraining;
	}
	
	//ensure all the operations are done as one unit of transaction within the same session
	@POST
	@Path("/add_participants")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Transactional
	public void addNewParticipantToTraining(@FormParam("courseId")int courseId, @FormParam("empno")int empno) {
		Participant p = getParrepository().findById(empno).get();
		Training t = getRepository().findById(courseId).get();
		
		if(!t.getParticipants().contains(p)) {
			t.getParticipants().add(p);
		}
		//p.getTrainings().add(t);
		getRepository().save(t);
	}
	
	@GET
	@Path("/registered_participants")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Transactional
	public Set<Participant> getParticipants (@QueryParam("courseId") int courseId){
		Training t = getRepository().findById(courseId).get();
		if(!t.getParticipants().isEmpty()) {
			return t.getParticipants();
		}else {
			return null;
		}
	}

}
