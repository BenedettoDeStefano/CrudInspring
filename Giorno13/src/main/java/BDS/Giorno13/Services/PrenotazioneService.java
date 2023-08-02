package BDS.Giorno13.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import BDS.Giorno13.Entities.Prenotazione;



@Service
public class PrenotazioneService {

	private List<Prenotazione> prenotazioni = new ArrayList<>();

	
	public Prenotazione save(Prenotazione prenotazione) {
		Random rndm = new Random();
		prenotazione.setId(rndm.nextInt());
		this.prenotazioni.add(prenotazione);
		return prenotazione;
	}

	public List<Prenotazione> getPrenotazioni() {
		return this.prenotazioni;
	}

	public Optional<Prenotazione> findById(int id) {
		Prenotazione pr = null;

		for (Prenotazione prenotazione : prenotazioni) {
			if (prenotazione.getId() == id)
				pr = prenotazione;
		}

		return Optional.ofNullable(pr);
	}

	public void findByIdAndDelete(int id) {
		ListIterator<Prenotazione> iterator = this.prenotazioni.listIterator();

		while (iterator.hasNext()) {
			Prenotazione currentPrenotazioni = iterator.next();
			if (currentPrenotazioni.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Prenotazione> findByIdAndUpdate(int id, Prenotazione prenotazione) {
		Prenotazione found = null;

		for (Prenotazione currentPrenotazioni : prenotazioni) {
			if (currentPrenotazioni.getId() == id) {
				found = currentPrenotazioni;
				found.setDataPrenotazione(prenotazione.getDataPrenotazione());
				found.setScadenzaPrenotazione(prenotazione.getScadenzaPrenotazione());
				found.setPostazione(prenotazione.getPostazione());
				found.setUtente(prenotazione.getUtente());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}
