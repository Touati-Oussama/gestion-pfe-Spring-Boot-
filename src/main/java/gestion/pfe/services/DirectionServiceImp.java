package gestion.pfe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.pfe.entities.Direction;
import gestion.pfe.repos.DirectionRepository;

@Service
public class DirectionServiceImp  implements DirectionService{

	@Autowired
	DirectionRepository directionRepository;
	
	@Override
	public Direction saveDirection(Direction e) {
		// TODO Auto-generated method stub
		return directionRepository.save(e);
	}

	@Override
	public Direction updateDirection(Direction e) {
		// TODO Auto-generated method stub
		return directionRepository.save(e);
	}

	@Override
	public void deleteDirection(Direction e) {
		directionRepository.delete(e);
		
	}

	@Override
	public List<Direction> getAllDirections() {
		// TODO Auto-generated method stub
		return directionRepository.findAll();
	}

	@Override
	public void deleteDirectionById(int id) {
		directionRepository.deleteById(id);
	}

	@Override
	public Direction getDirection(int id) {
		// TODO Auto-generated method stub
		return directionRepository.findById(id).get();
	}


}
