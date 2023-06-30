# TicTacToe With Minimax Algorithm and Alpha-Beta Pruning
> Source code made to create a TicTacToe game using Minimax Algorithm that is optimized with Alpha-Beta Pruning

## Table of Contents
- [Author](#author)
- [Program Implementation](#program-implementation)
- [Repository Structure](#repository-structure)
- [Requirements](#requirements)
- [How to Run](#how-to-run)

## Author
| NIM      | Name                      |
| -------- | ------------------------- |
| 13521062 | Go Dillon Audris          |

## Program Implementation
soon to be

## Repository Structure
```bash
.
├─── doc
│   └─── Answers.pdf
├─── bin  
│   └─── .gitignore
├─── src
│   ├─── Algorithm
│   │   └─── Minimax.java
│   ├─── Containers
│   │   ├─── Board.java
│   │   ├─── Drawable.java
│   │   ├─── OPanel.java
│   │   ├─── Panel.java
│   │   └─── XPanel.java
│   ├─── Services
│   │   ├─── Bot.java
│   │   ├─── Checker.java
│   │   ├─── Human.java
│   │   ├─── Logger.java
│   │   ├─── Player.java
│   │   └─── Runner.java
│   └─── Main.java
└─── README.md
```

## Requirements
Make sure you have Java Languange installed to your device

## How to Run
1. Do *clone repository* through terminal using this command.
    ``` bash
    $ git clone https://github.com/GoDillonAudris512/TicTacToe_With_Minimax.git
    ```
2. Go to src directory and do compilation to bytecode file using this command.
   ``` bash
    $ cd src
    $ javac Main.java -d ../bin
   ```
3. If the bytecode file compilation succeed, you will see several files with .class extension in the bin directory.
   Go to bin directory and run the program using this command.
   ``` bash
    $ cd ../bin
    $ java Main
   ```