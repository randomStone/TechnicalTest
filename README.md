Assumptions Made

a. That cells not within the specified area of a gamestate (i.e cols and rows greater than of what getcols() and getrows() return) are all dead. 

b. That the hashcode for the inner class "cell" never collides.

c. That any previously generated gamestates are valid when passed to the evolve function.
