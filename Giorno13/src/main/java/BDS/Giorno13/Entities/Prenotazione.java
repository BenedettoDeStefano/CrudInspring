package BDS.Giorno13.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Postazione postazione;

	private LocalDate dataPrenotazione;
	private LocalDate scadenzaPrenotazione;

}
