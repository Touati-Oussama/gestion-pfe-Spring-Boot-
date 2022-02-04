package gestion.pfe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.pfe.entities.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Integer> {

}
