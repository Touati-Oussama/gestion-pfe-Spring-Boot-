package gestion.pfe.services;

import java.util.List;

import gestion.pfe.entities.Direction;

public interface DirectionService {

	Direction saveDirection(Direction e);
	Direction updateDirection(Direction e);
	void deleteDirection(Direction e);
	void deleteDirectionById(int id);
	Direction getDirection(int id);
	List<Direction> getAllDirections();
}
