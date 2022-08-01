package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.BaseTest;
import utils.communs.Web;
import utils.reports.GeradorWordSteps;
import utils.reports.ReportVariables;
import utils.reports.VideoReord;


public class Hooks extends BaseTest {

    VideoReord videoReord = new VideoReord();

    @Before()
    public void beforeScenario(Scenario scenario) {
        initializeWebApplication(Web.CHROME);
        ReportVariables.setNome_cT(scenario.getName());
        scenario.toString();
        System.out.println("Teste execução Hooks Web");
        try {
            videoReord.startRecording();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After()
    public void afterScenario(Scenario scenario) throws Exception {
        ReportVariables.setStatus(scenario.getStatus());
        GeradorWordSteps geradorWordSteps = new GeradorWordSteps();
        videoReord.stopRecording();
    //    geradorWordSteps.generateWord();
        closeWeb();
    }

}
