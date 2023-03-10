package com.juaracoding.post24;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features/Login.feature",
        glue = {"com.juaracoding.post24"}
)
public class RunnerClass extends AbstractTestNGCucumberTests {

}