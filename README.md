# [Hangman](misc/Hangman.png)

Test your vocabulary in this game by guessing each of the letters to uncover the word or phrase.
### Tools
**Java** as the primary language to implement the MVC architecture, **JavaFX** for the GUI, **Intellij** IDE for development environment, and **JUnit** for the testing framework.
### Scope and Objective of project
The Scope and objective of what this project aims to solve can be found [here](Assignment1_Winter2021.pdf).
## Execution
In order to execute the Hangman game JavaFX is  required. You can download JavaFX [here](https://gluonhq.com/products/javafx/) and find installation instructions [here](https://openjfx.io/openjfx-docs/)
### Execution of Hangman in Intellij
You may run the code as the JavaFX installation guide indicates. The starting point for the Hamgman application can be found by right clicking main.java and selecting `Run main` in the [context menu](misc/Run Hangman in Intellij.png).

### Execution of Hangman Tests in Intellij
In order to execute hangman tests, right click and navigate to the [context menu](misc/Running tests.png) to select the type of test you'd like to run. Coverage test reports are located [here](out/test/Hangman/sample/sample). You may view the report in Intellij once a coverage test has been executed, or a [browser](Generate Coverage Report and Display in Browser.png) and can be viewed in any browser.

## Functionalities
Hangman has an intuitive UI consisting of the slots the character will be entered and the buttons to cause the event. It follows an MVC style architecture of which the Hangman.java, Hangman.fxml, and HangmanController.java are designed to be respectfully. It uses JavaFX as a framework to develop as an application and tests using Junit.

## Software Process Chosen
The Agile Model was chosen process due to easy modifiability. Due to JavaFX being a new framework I will be working with for a first time, utilizing an agile process allows me to implement newer features and create optimizations to existing code without having to develop from scratch. It also allows me to publish a working prototype into production (could not be done due to a build error with the JDK) and simultaneously continue developing.

## Challenges
A major difficulty I came across while writing my tests was trying to get a larger coverage. This was rendered unsuccessful as most of my code was bonded to the JavaFX components and methods. I would require another library to test this aspect of my code. However, I was able to write some tests and run coverage on them by splitting my code into testable methods.

I also wasn’t able to build an executable for this project as Oracle removed this functionality in the JDK

