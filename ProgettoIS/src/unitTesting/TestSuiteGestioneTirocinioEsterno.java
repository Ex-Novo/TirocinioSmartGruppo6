package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestApprovazioneConvenzione.class, TestApprovazioneTirocinio.class, TestElencoRichieste.class,
		TestRichiestaConvenzione.class, TestRichiestaTirocinio.class })
public class TestSuiteGestioneTirocinioEsterno {

}
