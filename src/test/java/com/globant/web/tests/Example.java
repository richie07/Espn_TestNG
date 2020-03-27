package com.globant.web.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Example {

    public Logger log = Logger.getLogger(Example.class);

    @Test(groups = {"group1", "group2"})
    public void hello () {
        log.info("Hello");
    }

    @Test(groups = {"group1"})
    public void welcome () {
        log.info("Welcome");
    }

    @Test(groups = {"group1"})
    public void goodbye () {
        log.info("Goodbye");
    }

    @Test(groups = {"group2"})
    public void name () {
        log.info("Juan");
    }
}
