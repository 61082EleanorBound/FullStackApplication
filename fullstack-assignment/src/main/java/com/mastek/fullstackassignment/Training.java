package com.mastek.fullstackassignment;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="JPA_Training_Courses")
@XmlRootElement //enable Java Object to XML data
public class Training {
	
	int courseId;
	
	@FormParam("name")
	String courseName;
	
	@FormParam("course_start_date")
	String courseStartDate;
	
	@FormParam("course_duration")
	int courseDuration;
	
	@FormParam("course_teacher")
	String courseTeacher;
	
	@FormParam("course_location")
	String courseLocation;
	
	Set<Participant> participants = new HashSet<>();

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="JPA_Participant_Training_Attendence",
		joinColumns= {@JoinColumn(name="FK_course_ID")},
		inverseJoinColumns= {@JoinColumn(name="FK_employee_number")})
	@XmlTransient//when asking for training data it will not request participant data, data given to the UI will be guarded
	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	@Override
	public String toString() {
		return "Training [courseId=" + courseId + ", courseName=" + courseName + ", courseStartDate=" + courseStartDate
				+ ", courseDuration=" + courseDuration + ", courseTeacher=" + courseTeacher + ", courseLocation="
				+ courseLocation + "]";
	}

	@Id
	@Column(name="course_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(name="course_name")
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Column(name="course_start_date")
	public String getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	@Column(name="course_duration")
	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Column(name="course_teacher")
	public String getCourseTeacher() {
		return courseTeacher;
	}

	public void setCourseTeacher(String courseTeacher) {
		this.courseTeacher = courseTeacher;
	}

	@Column(name="course_location")
	public String getCourseLocation() {
		return courseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		this.courseLocation = courseLocation;
	}
	
	
	
}
