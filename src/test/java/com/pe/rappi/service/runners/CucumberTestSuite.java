package com.pe.rappi.service.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"com.pe.rappi.service.stepsdefinitions"})
public class CucumberTestSuite {
}
