# API tests for [Reqres.in](https://reqres.in/)

---


<a href="https://reqres.in/"><img src="./media/reqres_logo.png"/></a>

---


## Content:

- <a href="#tools">Tools and technologies</a>
- <a href="#facts">Project features</a>
- <a href="#scenarios">Test scenarios</a>
- <a href="#cli">Launch from the CLI</a>
- <a href="#jenkins">CI/CD with Jenkins</a>
- <a href="#allure">Allure reporting</a>
- <a href="#allure-testops">Integration with Allure TestOps</a>
- <a href="#jira">Integration with JIRA</a>
- <a href="#telegram">Bot notifications in Telegram</a>


<a id="tools"></a>
## Tools and technologies
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="./media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="./media/logo/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://rest-assured.io/"><img src="media/logo/Restassured.png" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="./media/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="./media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="./media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="./media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="./media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="./media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="./media/logo/JIRA.svg" width="50" height="50"  alt="Jira"/></a>
</p>

<a id="facts"></a>
## Project features
* Request/response specifications
* Custom `tpl` templates for `Allure` report logging
* Test cases as a documentation with `Allure TestOps`
* Launch all or separate tests from TMS directly
* `JIRA` integration
* Telegram notifications

<a id="scenarios"></a>
## Test Scenarios
* [x] Checking the successful getting of a user
* [x] Checking the successful deleting of a user
* [x] Checking the successful creation of a new user
* [x] Checking the unsuccessful creation of a new user with Bad Request error
* [x] Checking the successful user update with put method
* [x] Checking the unsuccessful user update with put method and Bad Request error
* [x] Checking the successful user update with patch method
* [x] Checking the unsuccessful user update with patch method and Bad Request error



<a id="cli"></a>
## <img alt="cli" height="25" src="./media/logo/run.png" width="25"> Launch from the CLI

All tests can be executed by command:
```bash  
./gradlew clean test
```


<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="./media/logo/Jenkins.svg" width="25"/></a><a name="CI/CD with Jenkins"></a>CI/CD with [Jenkins](https://jenkins.autotests.cloud/job/26-merkuzio88-reqres/)</a>
<img alt="Jenkins" src="./media/reports/Jenkins.jpg"> 

### Jenkins job

- `COMMENT` parameter (by default @asolqa is tagged)

After the build is done the test results are available in `Allure`, `Allure TestOps` and `JIRA`

<a id="allure"></a>
## <img alt="Allure" height="25" src="./media/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [reporting](https://jenkins.autotests.cloud/job/26-merkuzio88-reqres/8/allure/#)</a>
<img alt="Allure" src="./media/reports/AllureReportExample.jpg"> 

`Allure` report includes request and response logging beautified with `tpl` templates:

<img alt="Allure2" src="./media/reports/AllureReportExample2.jpg">


<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="./media/logo/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4325/dashboards">Allure TestOps</a>

`Allure TestOps` processes tests as a documentation and allows to launch them directly from TMS.

Here all test cases execution results are available.

Dashboard contains test runs statistics:
<img alt="Dashboard" src="./media/reports/Dashboard.jpg">

All test cases:
<img alt="Cases1" src="./media/reports/TestOpsAutomated.jpg">

To execute tests from TestOps move to <a target="_blank" href="https://allure.autotests.cloud/project/4325/jobs">Jobs</a>:
<img alt="Launch" src="./media/reports/LaunchJob1.jpg">

Click to run Job, select needed/all items and submit launch:
<img alt="Launch" src="./media/reports/LaunchJob.jpg">

Launches:
<img alt="Launch" src="./media/reports/Launches.jpg">



<a id="jira"></a>
## <img alt="Allure" height="25" src="./media/logo/JIRA.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1299">Jira</a>

`Jira` has information about all related test cases, their statuses and launches results from `Allure TestOps`:

<img alt="JIRA" src="./media/reports/JIRA.jpg">

<a id="telegram"></a>
## <img alt="Allure" height="25" src="./media/logo/Telegram.svg" width="25"/></a> Bot notifications in Telegram
After every build Telegram bot sends notification with `Allure` report:

<img alt="Bot" src="./media/reports/Telegram_screen.jpg"> 









