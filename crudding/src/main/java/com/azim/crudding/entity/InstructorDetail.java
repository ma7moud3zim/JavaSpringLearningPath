package com.azim.crudding.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructor_detail")

public class InstructorDetail {
	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names 
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="youtube_channel")
	private String ytChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(int id, String ytChannel, String hobby) {
		this.id = id;
		this.ytChannel = ytChannel;
		this.hobby = hobby;
	}
	
	public InstructorDetail(String ytChannel, String hobby) {
		this.ytChannel = ytChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYtChannel() {
		return ytChannel;
	}

	public void setYtChannel(String ytChannel) {
		this.ytChannel = ytChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", ytChannel=" + ytChannel + ", hobby=" + hobby + "]";
	}
	
	

}
