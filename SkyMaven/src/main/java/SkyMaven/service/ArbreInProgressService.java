package SkyMaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SkyMaven.entity.ArbreInProgress;
import SkyMaven.repository.ArbreInProgressRepository;

@Service
public class ArbreInProgressService {
@Autowired 
private ArbreInProgressRepository tripRepository;


	public List<ArbreInProgress> getAll() {
		return tripRepository.findAll();
	}
	public ArbreInProgress getById(Long id) {
		return tripRepository.findById(id).orElseThrow(RuntimeException::new);
	}

	public void create(ArbreInProgress trip) {
		tripRepository.save(trip);
	}

	public ArbreInProgress update(ArbreInProgress trip) {
		return tripRepository.save(trip);
	}
	
	public void deleteById(Long id) {
		ArbreInProgress trip = new ArbreInProgress();
		trip.setId(id);
		trip.setSkyKid(null);
		trip.setTref(null);
		tripRepository.delete(trip);
	}
}