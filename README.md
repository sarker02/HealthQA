# Web Test Automation Project for Inductive Health Web Interface.


### Checkout framework code from github
   git clone https://github.com/sarker02/HealthQA.git

### Load maven depenecies from windows command line:
   mvn dependency:resolve

### Compile the code
   mv compile

### Run cucumber tests having tag - 'Smoke' from intelij terminal 
   mvn test -D"cucumber.filter.tags=@Smoke"

### Run cucumber tests having tag - 'Smoke' from intelij windows command line 
   mvn test -Dcucumber.filter.tags="@Smoke"



###Technology Stack:
   Selenium Webdriver, Cucumber BDD with Java
   

### Test Runner File
		src/main/java/utils/TestRunner.java

### Config Properties File:
		config/config.properties

### Log File:
		logs/health_tests.log

### Screenshots Directory:
		screenshots/
		
### Extent Reports Directory
		reports/
	
### Features Directory
		src/test/resources/features/
		
### Test Data Directory
		data/
		
### Step Definitions Directory
		src/main/java/steps/
		
### Page Object Model Pages Directory
		src/main/java/pages
		
		

