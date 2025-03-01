package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name="Hotel")
public class Hotel {
	
	@Id  //it will be serve as primary key 
	@GeneratedValue(strategy=GenerationType.IDENTITY)// use for genrate unique
	private Long id;
	
	@NotBlank(message="Name Required")
	private String name;
	@Size(min=2,max=50,message="Type must be less than 50 and greater than 2")
	private String hoteltype;
	private String quality;
	@NotBlank(message = "Password cannot be empty")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
        message = "Password must be 8-20 characters long, include at least one uppercase letter, one lowercase letter, one number, and one special character."
    )//@Pattern ensures secure password validation with predefined rules.
	//@ConstraintValidator
	
	private String password;
	
	
	//non parameterized construction
	public Hotel() {
		
		
	}
	
	// paramertized construction

	public Hotel(String name, String hoteltype, String quality,String password, Long id) {
		super();
		this.name = name;
		this.hoteltype = hoteltype;
		this.quality = quality;
		this.password=password;
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHoteltype() {
		return hoteltype;
	}
	public void setHoteltype(String hoteltype) {
		this.hoteltype = hoteltype;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getPassword(String password) {
		return password;
	}
	public void setPassword(String password) {
		this.password= password;
	}
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", hoteltype=" + hoteltype + ", quality=" + quality + ", password="+password+", id=" + id + "]";
	}
	
	

}
