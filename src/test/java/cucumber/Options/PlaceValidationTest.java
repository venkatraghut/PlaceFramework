package cucumber.Options;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // This maps to src/test/resources/features
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,  value = "stepDefinations")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@DeletePlace")  // 👈 add your tag here

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/jsonReports/cucumber-report.json")
public class PlaceValidationTest {
}


//package cucumber.Options;
//
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources/features",
//glue = {"stepDefinations"})
//
//public class PlaceValidationTest {
//
//}
