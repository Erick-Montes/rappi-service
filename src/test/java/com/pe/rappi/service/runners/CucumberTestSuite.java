package com.pe.rappi.service.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin={"summary","pretty","json:target/cucumber-report/TestResult.json"},features = {"src/test/resources/features"}, glue = {"com.pe.rappi.service.stepsdefinitions"},snippets = CucumberOptions.SnippetType.CAMELCASE,dryRun = false)
public class CucumberTestSuite {
}
