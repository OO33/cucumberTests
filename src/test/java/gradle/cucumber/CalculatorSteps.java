package gradle.cucumber;

import jdk.jfr.Registered;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps {
 
    private int total;
 
    @Given("^I have a calculator$")
    public void initializeCalculator() throws Throwable {
        //
    }
 
    @When("^I add (-?\\d+) and (-?\\d+)$")
    public void testAdd(int num1, int num2) throws Throwable {
        total = num1 + num2;
    }
 
    @Then("^the result should be (-?\\d+)$")
    public void validateResult(int result) throws Throwable {
        Assert.assertEquals(result, total);
    }
}