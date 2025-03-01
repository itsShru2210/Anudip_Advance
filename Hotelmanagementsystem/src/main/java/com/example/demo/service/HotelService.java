package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Hotel;
import com.example.demo.respository.*;

@Service  //served as a service class

public class HotelService {
	
	@Autowired
	private HotelRespository hotelRespository;
	
	
	//getting data
	public List<Hotel>getAllHotel(){
		return hotelRespository.findAll();
	}
	
	//saving data
	public Hotel saveHotel(Hotel hotel) {
		return hotelRespository.save(hotel);
	}
	
	//updating
	
	public Hotel updateHotel(Hotel hotel) {
		return hotelRespository.save(hotel);
		
	}
	//Get Hotel Id
	public Hotel gethotelbyId(Long id) {
		return hotelRespository.findById(id).orElse(null);
	}
	
	//deleting hotel by id
	public boolean deleteHotelById(Long id) {
		if(hotelRespository.existsById(id)) {
			 hotelRespository.deleteById(id);
			return true;
		}else {
		return false;
	}

}
	}
