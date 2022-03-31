# Wordle

## Introduction

Wordle was created by software engineer and former Reddit employee, Josh Wardle, and was launched in October 2021.  I started seeing posts on Stack Overflow about three weeks ago questioning how to create a Swing GUI for this game.  I thought it would make an interesting mini-project, and as usual, I underestimated the amount of effort.  The project took me about 40 hours to complete.

Here's what I came up with.  I based my GUI design on the New York Times online version of Wordle.

![Opening JFrame](readme-resources/wordle1.png)

The GUI is 655 x 716 and should fit comfortably oin almost all modern monitors.

Clicking the Help menu and the Instructions submenu give you the instructions dialog.  Here's the first part of the instructions dialog.

![Instructions JDialog](readme-resources/wordle2.png)

Clicking on the About submenu gives you the obligatory about dialog.  Here's the about dialog.

![About JDialog](readme-resources/wordle3.png)

Here's what the main game looks like after guessing five out of my six chances.  This was a tough word and I wasn't quite awake yet.  You can use the virtual keyboard on the GUI, or you can use your actual keyboard.

Pressing the Esc key on any part of the GUI will close the dialog or close the application.

![Game play](readme-resources/wordle4.png)

Here's the statistics screen after I luckily got the word on my 6th guess.  Most of the games were "won" in a testing mode where I knew what the secret word was.

![Statistics JDialog](readme-resources/wordle5.png)

Pressing Enter on this dialog will clear the game board and allow you to guess the next word.  The application has over 4,000 5-letter words, so you can play for hours if you wish.

## Explanation

Oracle has a helpful tutorial, [Creating a GUI With Swing](https://docs.oracle.com/javase/tutorial/uiswing/index.html).  Skip the Learning Swing with the NetBeans IDE section.  Pay close attention to the [Concurrency in Swing](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html) and the [Laying Out Components Within a Container](https://docs.oracle.com/javase/tutorial/uiswing/layout/index.html) sections.

When I create a Swing GUI, I use the [model-view-controller](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller) (MVC) pattern.  The name implies that you create the model first, then the view, and finally the controller.  For this project, I completed the vast majority of the model before I started on the view.

An application model consists of one or more plain Java getter/setter classes.  A view consists of a JFrame and one or more JPanels.  A controller consists of one or more action classes.

The model for this project consists of five classes.  The view for this project consists of one main `JFrame`, a statistics `JDialog`, an instructions `JDialog`, and an about `JDialog`.  The `JFrame` is divided into three `JPanels`; the title `JPanel`, the game grid `JPanel`, and the keyboard `JPanel`.  The controllers for this project consists of a `Runnable` to read and extract the 5-letter words from a text file I downloaded, an `AbstractAction` to process the keyboard JPanel clicks, and several private inner classes to handle the Esc and Enter keys and other small, self-contained tasks.

