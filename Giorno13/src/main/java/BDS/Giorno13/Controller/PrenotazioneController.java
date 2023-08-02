package BDS.Giorno13.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

	@GetMapping("/italiano")
	public String indexItaliano() {
		return "Pagina principale";
	}

	@GetMapping("/inglese")
	public String indexIngles() {
		return "Main page";
	}

	@GetMapping("/regole")
	public ResponseEntity<String> getRegolePrenotazione(@RequestParam String lingua) {
		String testoRegole;
		if ("italiano".equalsIgnoreCase(lingua)) {
			testoRegole = "Regole di prenotazione in italiano";
		} else if ("inglese".equalsIgnoreCase(lingua)) {
			testoRegole = "Booking rules in English";
		} else {
			return ResponseEntity.badRequest().body("Lingua non supportata");
		}
		return ResponseEntity.ok(testoRegole);
	}


}
