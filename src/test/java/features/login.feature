Feature: Login into Application
Scenario Outline: Positive test validation login
Given Initalize the browser with chrome browser
And Navigate to "http://www.qaclickacademy.com/" Site
And click on Login link in home page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close browser

Examples:

	|username 				|		|password|
	|manukhattra13@gmail.com|	 	|123654	 |
	|raminderkhera@gmail.com|		|789456	 |
	