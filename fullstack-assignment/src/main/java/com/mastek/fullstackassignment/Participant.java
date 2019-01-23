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
@Table(name="JPA_Participants")
@XmlRootElement
public class Participant {
	
	int empno;
	
	@FormParam("employee_name")
	String name;
	
	@FormParam("employee_job_title")
	String jobTitle;
	
	@FormParam("employee_department")
	String department;
	
	Set<Training> trainings = new HashSet<>();
	
	@ManyToMany(mappedBy="participants",fetch=FetchType.LAZY)
	@XmlTransient
	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	@Override
	public String toString() {
		return "Participant [empno=" + empno + ", name=" + name + ", jobTitle=" + jobTitle + ", department="
				+ department + "]";
	}

	@Id
	@Column(name="employee_number")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	@Column(name="employee_name",length=25,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="employee_job_title",length=25,nullable=false)
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name="employee_department",length=25,nullable=false)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
