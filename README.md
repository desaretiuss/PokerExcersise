## Poker Hands
This is a solution of problem [Poker Hands](https://projecteuler.net/problem=54) (Project Euler), implemented in Java language.

### Description
There are two key parts in the program.
1. Processing the input data. Parsing and organizing it accordingly into java Models.
2. Evaluating each poker hand to facilitate comparison between them.
   1. **N.B** the algorithm for evaluation was taken from this [comment](https://stackoverflow.com/a/20962807) on StackOverflow, which has been
      seemingly marked as **Community Wiki** after multiple revisions.

### Execution
The program is developed on Intellij IDEA. 
To start processing the data and display the result, it is enough to execute the method **main** of class **org.verdiseno.App**.

### Tests
There are two unit tests: **HandEvaluatorTest** and **InputDataProcessor** which test respectively the main
parts of the program. The test data were taken from the example data provided in the problem description on Project Euler's page.

### What could be improved ?

- The actual implementation does not take into account the **Royal Flush**-es, which need to be fixed.
- Implementing more advanced evaluation algorithms which allow for processing of millions of poker hands data much faster. For example, this [algorithm](http://suffe.cool/poker/evaluator.html) seems widely used in the field.
- Adapt the program to allow for a dynamic number of players since currently it works only for 2 players.
- Creating some Abstract classes to allow for possible extensions of program in the future.

### Project Structure

      |-- main
      |   |-- java
      |   |   |-- org
      |   |   |   |-- verdiseno
      |   |   |   |   |-- App.java
      |   |   |   |   |-- config
      |   |   |   |   |   |-- PropertiesLoader.java
      |   |   |   |   |-- logic
      |   |   |   |   |   |-- HandEvaluator.java
      |   |   |   |   |   |-- InputDataProcessor.java
      |   |   |   |   |-- model
      |   |   |   |   |   |-- Card.java
      |   |   |   |   |   |-- Hand.java
      |   |   |   |   |   |-- HandCategory.java
      |   |   |   |   |   |-- HandEvaluationData.java
      |   |   |   |   |   |-- HandResult.java
      |   |   |   |   |   |-- Rank.java
      |   |   |   |   |   |-- Suit.java
      |   |-- resources
      |   |   |-- application.properties
      |   |   |-- poker.txt
      |-- test
      |   |-- java
      |   |   |-- org
      |   |   |   |-- verdiseno
      |   |   |   |   |-- logic
      |   |   |   |   |   |-- HandEvaluatorTest.java
      |   |   |   |   |   |-- InputDataProcessorTest.java
      |   |   |-- util
      |   |   |   |-- ResultInfo.java
      |   |-- resources
      |   |   |-- poker-test.txt

#### Language & Libraries used

- Java (JDK 16)
- Maven
- jUnit 4.13
- Log4j 2.17
- Lombok 1.8
