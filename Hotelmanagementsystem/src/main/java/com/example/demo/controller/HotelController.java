package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	
	@Autowired
	private HotelService hotelService;

	
	//getting data by getmapping
	@GetMapping("/{id}")
	public List<Hotel> getAllHotel(){
		return hotelService.getAllHotel();		
	}
	
	//create hotel for adding new hotel by postmapping
	@PostMapping("/{id}")
	public Hotel addHotel(@RequestBody Hotel hotel) {
		return hotelService.saveHotel(hotel);
	}
	
	
//updating hotel data by using put mapping
	@PutMapping("/{id}")
	public ResponseEntity<Hotel>updateHotel(@PathVariable Long id,@Valid @RequestBody Hotel updateHotel){
		Hotel exitingHotel=hotelService.gethotelbyId(id);
		
		if(exitingHotel!=null) {
			exitingHotel.setName(updateHotel.getName());
			exitingHotel.setHoteltype(updateHotel.getHoteltype());
			exitingHotel.setPassword(updateHotel.getPassword(null));
			exitingHotel.setQuality(updateHotel.getQuality());
			
			Hotel  savedHotel =hotelService.updateHotel(exitingHotel);
			return ResponseEntity.ok(savedHotel);
		}else{
			return ResponseEntity.notFound().build();	
			}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotelById(@PathVariable Long id){
		boolean isDeleted=hotelService.deleteHotelById(id);
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}



