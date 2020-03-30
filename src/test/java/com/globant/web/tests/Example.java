package com.globant.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example {

    public Logger log = Logger.getLogger(Example.class);

    @BeforeSuite
    public void beforeSuite() {
        log.info ("Before Suite");
    }

    @BeforeClass
    public void beforeClass() {
        log.info ("Before Class");
    }

    @BeforeTest
    public void beforeTest() {
        log.info ("Before Test");
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info ("Before Method");
    }

    @AfterSuite
    public void afterSuite() {
            log.info ("After Suite");
    }

    @AfterClass
    public void afterClass() {
        log.info ("After Class");
    }

    @AfterTest
    public void afterTest() {
        log.info ("After Test");
    }

    @AfterMethod
    public void afterMethod() {
        log.info ("After Method");
    }

    @Test(groups = {"group1", "group2"})
    public void hello() {
        log.info("Hello");
    }

    @Test(groups = {"group1"})
    public void welcome() {
        log.info("Welcome");
    }

    @Test(groups = {"group1"})
    public void goodbye() {
        log.info("Goodbye");
    }

    @Test(groups = {"group2"})
    public void name() {
        log.info("Juan");
    }
}
