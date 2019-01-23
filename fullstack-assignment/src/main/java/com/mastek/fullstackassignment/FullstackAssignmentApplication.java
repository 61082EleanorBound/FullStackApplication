package com.mastek.fullstackassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FullstackAssignmentApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =
		SpringApplication.run(FullstackAssignmentApplication.class, args);
	
		ParticipantAccessAPI participantAPI =
				ctx.getBean(ParticipantAccessAPI.class,args);
		
		TrainingAccessAPI trainingAccessAPI =
				ctx.getBean(TrainingAccessAPI.class,args);
		
/*		Participant p1 = new Participant();
		p1.setName("Scott Disic");
		p1.setJobTitle("Trainee Developer");
		p1.setDepartment("Technology");
		
		Participant p2 = new Participant();
		p2.setName("Kandy Jones");
		p2.setJobTitle("Sales Director");
		p2.setDepartment("Sales");
		
		p1 = participantAPI.addParticipant(p1);
		p2 = participantAPI.addParticipant(p2);
		
		for(Participant p: participantAPI.listParticipants()) {
			System.out.println(p);
		}
		
		
		Training t1 = new Training();
		t1.setCourseName("Data Security");
		t1.setCourseDuration(1);
		t1.setCourseLocation("Leeds");
		t1.setCourseStartDate("01.01.2019");
		t1.setCourseTeacher("Jones");
		
		Training t2 = new Training();
		t2.setCourseName("Sales Introdcution");
		t2.setCourseDuration(20);
		t2.setCourseLocation("Leeds");
		t2.setCourseStartDate("14.02.2019");
		t2.setCourseTeacher("Sameer");
	
		for(Training t: trainingAccessAPI.listTrainings()) {
			System.out.println(t);
		}
		
		t1 = trainingAccessAPI.addTraining(t1);
		t2 = trainingAccessAPI.addTraining(t2);
		
		t1.getParticipants().add(p1);
		t2.getParticipants().add(p1);
		t1.getParticipants().add(p2);
		
//		p1.getTrainings().add(t1);
		t1 = trainingAccessAPI.addTraining(t1);
		t2 = trainingAccessAPI.addTraining(t2);
 		
 		
		
//		trainingAccessAPI.addNewParticipantToTraining(4, 2);
//		System.out.println(trainingAccessAPI.getParticipants(4));


		ctx.close();*/
	
	}

}

