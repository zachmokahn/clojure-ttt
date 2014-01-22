# Clojure Tic Tac Toe

### Iteration 1 (2 Days)

Requirements
  * Command Line Interface
  * Really Dumb (Computer Randomly Chooses an Available Space)

## Day 1
---
* Established the markers for the player, computer, and blank space.
* Established an empty board as a vector.
* Established a move validator.
* Established a 'move' which returns a new vector with the provided maker at the
  provided index.
* Established a 'winner?' and 'draw?' method

Thoughts on the Day:
Wrapping my head around making a move was hard, instead of just changing the
object like I would in Ruby or Javascript, I was returning a brand
new vector that inserted the marker at the given index. Establishing a winner
was easier than I anticipated. I spent the remainder of the day trying to find 
out how I would keep track of the changes I've made in order to play out a 
full game.

I punted this and finding the available spaces until the next morning.


## Day 2
---
* Decided to pass the board recursively to keep up with 'changes'
* Attained available indexes through the 'keep-indexed' function
* Created a Game namespace
* Created output for win/lose/draw
* Created prompt for selecting move
* Tied Board into Game and created a play sequence

Thoughts on the Day:
Finally realizing that I could pass the board recursively was like finding
enlightenment. Figuring out how recursion worked in Clojure was not as intuitive
as I though. I tried it like I would in Ruby by calling the function in the
function. I googled it and came across recurs, looked up the docs, and finally
created my game loop. At this point I was able to tie in a prompt and a board
display. The finally thing I had left was to get the indexes of all the
available spaces so that the computer could randomly select one.


###SUMMARY:
---
Two Namespaces:
Board
Board takes care of the constants and the new-board vector. It detects a win or
draw, as well as create a new vector with a new move on it, but returns the same
vector if an invalid move is played.
Game
Game takes care of the rules and displaying the game. It takes care of
alternating turns and stopping gameplay when the game is over. The game function
displays the board and checks if the game is over. If the game is over it will
announce the results, if it's not over it will check the turn, if the turn
belongs to the computer, the computer will randomly select an available position
and a new vector is recursed and the turn is alternated. If it's the human's turn
it will prompt the human to select an available index. If they make an invalid
move the original vector is recursed and the turn is not changed, repeating the
same process, if the move is valid the new vector is recursed and the turn is
alternated.


## To Play
---
1. Clone the Repo
``` $ git clone ****REPO***** ```
2. cd into the project
``` $ cd ttt```
3. Make sure the lein script is accessible
``` $ lein -v```
<sup>(If not follow [these](http://blog.zacharyjdavy.com/clojure) simple directions for getting it on your machine)</sup>
3. Run the game
``` $ lein run```
4. Win. You should really be able to Win.

To play a move just select an available index from the display and type it in
here: ``` select your move! ```

To quit press ```ctrl + c```

