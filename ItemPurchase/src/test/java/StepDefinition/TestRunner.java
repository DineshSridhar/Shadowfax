package StepDefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\feature\\Purchase.feature",tags= {},monochrome=true,glue="StepDefinition",dryRun=false,
plugin= {"html:target"})

public class TestRunner {

}
