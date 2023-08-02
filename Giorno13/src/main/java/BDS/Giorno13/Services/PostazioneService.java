package BDS.Giorno13.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import BDS.Giorno13.Entities.Postazione;


@Service
public class PostazioneService {

	private List<Postazione> postazioni = new ArrayList<>();

	public Postazione save(Postazione postazione) {
		Random rndm = new Random();
		postazione.setId(rndm.nextInt());
		this.postazioni.add(postazione);
		return postazione;
	}

	public List<Postazione> getPostazioni() {
		return this.postazioni;
	}

	public Optional<Postazione> findById(int id) {
		Postazione p = null;

		for (Postazione postazione : postazioni) {
			if (postazione.getId() == id)
				p = postazione;
		}

		return Optional.ofNullable(p);
	}

	public void findByIdAndDelete(int id) {
		ListIterator<Postazione> iterator = this.postazioni.listIterator();

		while (iterator.hasNext()) {
			Postazione currentPostazione = iterator.next();
			if (currentPostazione.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Postazione> findByIdAndUpdate(int id, Postazione postazione) {
		Postazione found = null;

		for (Postazione currentPostazione : postazioni) {
			if (currentPostazione.getId() == id) {
				found = currentPostazione;
				found.setCitta(postazione.getCitta());
				found.setDescrizione(postazione.getDescrizione());
				found.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
				found.setTipo(postazione.getTipo());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}

