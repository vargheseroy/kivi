## Getting Started

> You may have played rock paper scissors before. Maybe you’ve used it to decide who pays for dinner or who gets first choice of players for a team.

> If you’re unfamiliar, rock paper scissors is a hand game for two or more players. Participants say “rock, paper, scissors” and then simultaneously form their hands into the shape of a rock (a fist), a piece of paper (palm facing downward), or a pair of scissors (two fingers extended). The rules are straightforward:

Rock smashes scissors.
Paper covers rock.
Scissors cut paper.

> This is a virtual implementation of the classic rock paper scissors game in Java, where you are playing the game with a computer.


## Rules to play the game

> Open the program in the editor and run it in the terminal. I used VSCode as the editor for writing this program. You can use the `Run Java` option in the top right corner of VSCode editor to run the code in VSCode terminal.

> The program will ask you to input your move.  Enter either one of "rock", "paper", or "scissors" as values. To quit the game, enter "quit". You can enter your move in either uppercase or lowercase letters. But spelling of the move must be correct, i.e, for example, entering sissor instead of scissors will throw error.

> Once you enter one of the move, the system will randomly generate a move from rock, paper or scissors. Then it will compare your input with this value and based on the rules will output whther you won, lost or tied that round.

> Then it will ask you whther you want to play again. Enter "yes" if you want to play again and "no" if you want to stop.

> Once you finish the game, the program will output how many rounds you've played, how many rounds you've won, how many games you've lost and how many games you've tied.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

> Meanwhile, the compiled output files will be generated in the `bin` folder by default.

`src` contains two folders, `main` and `test`.  `main` contains the actual executable code for the game and `test` contains a couple of unit tests for the code.

> Debug logs are added inside the file `/bin/log/debug.log`. They will be automatically generated when you play the game.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
