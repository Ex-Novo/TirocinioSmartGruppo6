package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/* Ricorda di rimuovere lo Studente e l'Azienda di test create (con valori di default) */

@RunWith(Suite.class)
@SuiteClasses({ TestLogin.class, TestRegistrazioneAzienda.class, TestRegistrazioneStudente.class })
public class TestSuiteGestioneDashboard {

}
