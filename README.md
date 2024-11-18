# Making Change

A simple java program that allows the user to enter an amount and the program will return the least number of bills and coins to make up that amount. Additionally, the program will display images of the bills in coins with the correct amount. This program is an introductory to java and using graphics features within java

## How To Run
- For the console demonstration run the `Register.java` file.
- For the GUI demonstration run the `MakingChange.java` file.

# Design Pattern Implementation

## What I Did
I added two design patterns to my money register project from Lab 1:

### Observer Pattern
This pattern helps my GUI automatically update whenever money is added or removed from the purse. It's like having the purse "notify" the display that it needs to refresh - better than having to manually update everything.

**Advantages:**
- Provides automatic updates to the GUI when the Purse content changes
- Eliminates need for manual refresh calls
- Allows for easy addition of new observers without modifying existing code

### Strategy Pattern
This lets me have different ways to make change without messing with the main Register class. Right now I just have one strategy (using the biggest bills/coins first), but I could easily add other ways to make change later. This also helps to separate

**Advantages:**
- Separates change-making from the Register class
- Allows for easy addition of new change-making strategies
- Makes the code more flexible and maintainable
- Simplifies testing of different change-making approaches

## Files I Created/Changed

### For the Observer Pattern:
- Created `PurseObserver.java` - Interface for anything that wants to watch the purse
- Created `PurseLogger.java` - Prints updates to the console (helps with debugging)
- Updated `Purse.java` - Added the ability to notify observers
- Updated `PursePanel.java` - Now automatically updates when the purse changes

### For the Strategy Pattern:
- Created `ChangeStrategy.java` - Interface for different ways to make change
- Created `DefaultChangeStrategy.java` - The current way we make change
- Updated `Register.java` - Now uses strategies to make change

## How They Work Together
The Register uses a strategy to make change, and whenever money gets added to the purse, all the observers (like the display panel) get notified and update automatically. Makes the code a lot cleaner and easier to work with!
