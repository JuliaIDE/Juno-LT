# Welcome.

# In Juno we'll be using the Julia language. This is a Julia file and
# lines beginning with # are comments.

# Here's some very simple code:

3*6+4

# We can evaluate code by right clicking on it and selecting "Evaluate".
# You should see the result, "22", pop up next to the code.

# It's quicker to use Ctrl-Enter (or Cmd-Enter on Mac). Try adding "+2"
# to this line and then evaluating.

2

# We can also define our own functions, such as this one which doubles a
# number:

function double(x)
  return 2x
end

# Click anywhere within the function definition and press `Ctrl-Enter`
# again. You should see a tick pop up next to the "end" to show that
# the function has been defined.

# Now we can call our function:

double(10)

# After evaluating this you should see the result "20" pop up. You may
# also notice that the "10" becomes underlined. Try clicking and
# dragging it from side to side to double another number.

# We can do more advanced things, like dealing with matrices. Try

x = rand(5, 5)

# If you evaluate this you'll see "Matrix Float64, 5×5" pop up next to it.
# A bold header like this indicates that you can click on the box
# to expand it and see the whole matrix.

# If you're not sure what a function does it's easy to find out. Just right
# click on the function's name (like "rand" above) and click "Show Docs".
# The shortcut for this is Ctrl-D. You can also remove the documentation
# by right clicking and selecting "Remove result".
