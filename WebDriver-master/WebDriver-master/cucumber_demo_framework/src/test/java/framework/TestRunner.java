package framework;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		// This creates cucumber reports
        plugin = {"pretty", "html:target/site/cucumber-pretty"},
        //This create auto method name in camelCase
        snippets = cucumber.api.SnippetType.CAMELCASE,
        
        //Path to your feature file
        features = {"src/test/resources/features"},
        // Specify tags to be executed
        //tags = {"@mobile-login-2"},
        //tags = {"@hotel-search-1"},
        //tags = {"@darksky-verifytemp"},
        //tags = {"@darksky-regression"},
        //tags = {"@darsky-temptimeline"},
        //tags = {"@darksky-daytemp"},
        //tags = {"@heroku-search"},
        //tags = {"@heroku-login"},
        //tags = {"@heroku-registration"},
        //tags = {"@heroku-email"},
        //tags = {"@darksky-todaysdate"},
        //tags = {"@heroku-check"},
        tags = {"@mobile-home-reset"},
        //tags = {"@mobile-home-slide"},
        //Specify step definition package name (Note: make sure to have this package on current directory)
        glue = {"stepdefinition"}
)
public class TestRunner {
	
}
