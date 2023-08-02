package BDS.Giorno13.Entities;



import BDS.Giorno13.Enum.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Postazione {

	@Id
	@GeneratedValue
	private int id;

	private String descrizione;
	private int numeroMassimoOccupanti;
	private String citta;

	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;

}
