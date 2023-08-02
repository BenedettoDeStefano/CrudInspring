package BDS.Giorno13.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import BDS.Giorno13.Entities.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Integer> {
	Optional<Utente> findByEmail(String email);
}
