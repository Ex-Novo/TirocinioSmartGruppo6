package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestLogin.class, TestRegistrazioneAzienda.class, TestRegistrazioneStudente.class })
public class TestSuiteGestioneDashboard {

}
