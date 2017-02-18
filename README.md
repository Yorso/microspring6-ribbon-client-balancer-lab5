##Lab 5 - Using Ribbon Clients

**Part 1, Run Config Server, Eureka, and the word servers**

1.  Let's make a fresh start: stop all of the services that you may have running from previous exercises.  If using an IDE you may also wish to close all of the projects that are not related to "lab-5" or "common".

2.  Start the common-config-server and the common-eureka-server.  These are versions of what you created and used in the last few chapters.

3.  Start 5 separate copies of the lab-5-word-server, using the profiles "subject", "verb", "article", "adjective", and "noun".  There are several ways to do this, depending on your preference:
  - If you wish to use Maven, open separate command prompts in the target directory and run these commands:
    - mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=subject"
    - mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=verb"
    - mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=article"
    - mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=adjective"
    - mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=noun"
  - Or if you wish to run from directly within STS, right click on the project, Run As... / Run Configurations... .  From the Spring Boot tab specify a Profile of "subject", UNCHECK live bean support, and Run.  Repeat this process (or copy the run configuration) for the profiles "verb", "article", "adjective", "noun".
		
4.  Check the Eureka server running at [http://localhost:8010](http://localhost:8010).   Ignore any warnings about running a single instance; this is expected.  Ensure that each of your 5 applications are eventually listed in the "Application" section, bearing in mind it may take a few moments for the registration process to be 100% complete.	

5.  Optional - If you wish, you can click on the link to the right of any of these servers.  Replace the "/info" with "/" and refresh several times.  You can observe the randomly generated words.

  **Part 2, Modify sentence server to use Ribbon**	

6.  Run the lab-5-sentence-server project.  Refresh Eureka to see it appear in the list.  Test to make sure it works by opening [http://localhost:8020/sentence](http://localhost:8020/sentence).  You should see several random sentences appear.  We will refactor this code to make use of Ribbon.

7.  Stop the lab-5-sentence-server.  Add the org.springframework.cloud / spring-cloud-starter-ribbon dependency.

8.  Open SentenceController.java.  Replace the @Autowired DiscoveryClient with an @Autowired LoadBalancerClient.  Note that this will temporarily break the code.

9.  Refactor the code in the getWord method.  Use your loadBalancerClient to choose a ServiceInstance, then use that serviceInstance to provide the URI to the RestTemplate.

10.  Run the project.  Test it to make sure it works by opening [http://localhost:8020/sentence](http://localhost:8020/sentence).  The application should work the same as it did before, though now it is using Ribbon client side load balancing.
