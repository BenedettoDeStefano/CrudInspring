package BDS.Giorno13.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BDS.Giorno13.Entities.Utente;
import BDS.Giorno13.Entities.UtenteRequestPayLoad;
import BDS.Giorno13.Exception.BadRequestException;
import BDS.Giorno13.Repository.UtenteRepository;


@Service
public class UtenteService {
	// **********************************************************
	private final UtenteRepository utr;

	@Autowired
	public UtenteService(UtenteRepository utr) {
		this.utr = utr;
	}

	public Utente create(UtenteRequestPayLoad body) {
		utr.findByEmail(body.getEmail()).ifPresent(user -> {
			throw new BadRequestException("L'email è già stata utilizzata");
		});
		Utente newUser = new Utente(body.getUsername(), body.getNomeCompleto(), body.getEmail());
		return utr.save(newUser);
	}

	// **********************************************************
	private List<Utente> utenti = new ArrayList<>();

	public Utente save(Utente utente) {
		Random rndm = new Random();
		utente.setId(rndm.nextInt());
		this.utenti.add(utente);
		return utente;
	}

	public List<Utente> getUtenti() {
		return this.utenti;
	}

	public Optional<Utente> findById(int id) {
		Utente u = null;

		for (Utente utente : utenti) {
			if (utente.getId() == id)
				u = utente;
		}

		return Optional.ofNullable(u);
	}

	public void findByIdAndDelete(int id) {
		ListIterator<Utente> iterator = this.utenti.listIterator();

		while (iterator.hasNext()) {
			Utente currentUtente = iterator.next();
			if (currentUtente.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Optional<Utente> findByIdAndUpdate(int id, Utente body) {
		Utente found = null;

		for (Utente currentUtente : utenti) {
			if (currentUtente.getId() == id) {
				found = currentUtente;
				found.setNomeCompleto(body.getNomeCompleto());
				found.setEmail(body.getEmail());
				found.setUsername(body.getUsername());
				found.setId(id);
			}
		}
		return Optional.ofNullable(found);

	}

}
