# CucumberProject
Cucumber project without Serenity, using TestContext class as a way to share data between steps, using dependency injection and DAO for storing data

The tests need to be run using the command:
mvn verify -Dtest=CucumberRunner -Devn=qa-env -Dbrowser=chrome