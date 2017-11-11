package com.mycompany.testing;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Ivan on 28.10.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"})
public class CucumberJvmTest {

}
