package com.latha.saucedemo;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Entry point: runs every .feature file under src/test/resources/features.
 * Run it from IntelliJ (green arrow) or with: mvn test
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
public class RunCucumberTest {
}
