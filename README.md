# automation
Automation Test Framework for Web Apps usin Selenium-java

# Framework Description:

The framework which I followed is 'TestNG Page Factory Model'. Below is the brief description on how this framework works:
Each page is defined as its own class.

Actions (including navigation) are represented as functions for a class.

Tests only talk to the page objects.

Page objects only talk to the driver.

Elements on the page are stored as variables for the page object

Class Inheritance can be used to define functionality to a set of pages.


# Prerequisites:
 
•	Java should be installed and path should be in environment variables.

•	tools and platform tools path should be added to environmental variables path.

•	Maven should be installed path should be in environment variables.

•	TestNG should be installed in execution IDE (Eclipse is suggestible).

•	Import the framework to available IDE (Eclipse is suggestible).


 
# Below are the steps to setup project properties:  

---- Select Framework -> Right click -> Click on Properties 
Click on Java Build Path -> Remove Existing JRE -> Add Library -> Select JRE System Library -> Next -> Click and Select Alternative JRE -> Finish -> Apply. 

Click on Java Compiler -> Select Compiler Compliance Level -> Apply.

Click on Project Facets -> Select Java Version -> Select Runtimes -> Apply -> Apply and Close 




To run TestNG suite file:
 
Right click on testng.xml file and Run as TestNG Suite.

We can run individual test classes as TestNG classes.

Note: Testcases are available in test(src/test/java/com/demo/test) package.
