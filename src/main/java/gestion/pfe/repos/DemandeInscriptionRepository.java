package gestion.pfe.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import gestion.pfe.entities.DemandeInscription;

public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Integer> {

}
