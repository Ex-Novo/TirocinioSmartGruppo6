package unitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFeedbackAzienda.class, TestFeedbackStudente.class,
    TestInserisciRegistro.class })
public class TestSuiteGestioneFeedback {

}
