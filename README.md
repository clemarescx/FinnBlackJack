# BlackJack

### Project
Code base of a simulation of a Black Jack card game for a technical exercise in Java + JUnit4.

### Requirements
* Java Runtime Environment 1.8.0 and up
* Maven 3.5.2 and up 

### Instructions
1. In a terminal, navigate to the root folder of the project (where the _pom.xml_ is located)
2. Run `mvn package`
3. Run 
```
java -cp target/FinnBlackJack-1.0-SNAPSHOT.jar com.clemarescx.blackjack.Blackjack
```

Optionally, you can give the program a custom deck of cards by passing the path to the deck file (e.g: _mydeck.txt_): 
```
java -cp target/FinnBlackJack-1.0-SNAPSHOT.jar com.clemarescx.blackjack.Blackjack mydeck.txt
```
Look inside _ordered_deck.txt_ to see how a deck file should be formatted.