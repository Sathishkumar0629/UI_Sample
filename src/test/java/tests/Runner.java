package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src\\test\\resources\\features\\UI_Sample.feature"},
							glue="glue",
							monochrome=true,
							plugin= {"pretty","html:target/results","rerun:target/failed.html"}
				)
public class Runner extends AbstractTestNGCucumberTests {

}
