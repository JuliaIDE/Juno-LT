# Welcome.

# This is a regular file, which you can edit as much as you want,
# then save for later or discard. You can open a fresh copy by
# pressing `Ctrl-Space` and typing `tutorial` followed by `Enter`.

# (and if you remember one thing, make it `Ctrl-Space` – you can
# get to everything in Juno via the command bar that pops up)

# Go to the `View->Console` menu to see any output. If you have
# issues, please let me know at http://discuss.junolab.org/

# ––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––––

# In Juno we'll be using the Julia language. This is a Julia file and
# lines beginning with `#` are comments.

# Here's a very simple code block:

3 * 6 + 4

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

# Click anywhere on the function definition and press `Ctrl-Enter`
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
# click on the function's name (like "rand" above) and click "Toggle Docs".
# The shortcut for this is Ctrl-D. You can also remove the documentation
# by right clicking and selecting "Remove result".

# Let's try installing a package, so we can do some plotting.

Pkg.add("")

# If you start to type `Gadfly` between the quotes (and don't already have
# it installed), you should see the autocomplete pop up with a list of
# packages. Select `Gadfly` with tab and evaluate to install the package.
# You'll see a working indicator in the bottom-left corner as the package
# is loaded. Go to the `View->Console` menu to see the output.

# Now you can load the package.

using Gadfly

# A few simple examples; if you want to learn more about Gadfly, check out
# http://www.gadflyjl.org/

# A simple scatter plot:
plot(x = rand(10), y = rand(10))

# Let's try a random walk:
plot(x = 1:100, y = cumsum(rand(100)-0.5), Geom.point, Geom.line)

# And smooth it out:
plot(x = 1:100, y = cumsum(rand(100)-0.5), Geom.point, Geom.smooth)

# We can plot functions:
plot(x -> x^3 - 9x, -5, 5)
plot([sin, cos], 0, 6)
# (and remember to try sliding the values up and down here, too)

# Ok, Let's try something more interesting. We'll need to install and
# load the Images.jl package.

Pkg.add("Images")
using Images

# Let's try visualising this function. You can type latex symbols by
# typing a `\` and selecting from the autocomplete, e.g. `\phi` or `\le`.

# You can use `Shift-Enter` to quickly evaluate definitions.

const ϕ = golden

function foo(z)
  c = (φ-2)+(φ-1)im
  max = 80
  for n = 1:max
    abs(z) ≥ 2 && return n-1
    z = z^2 + c
  end
  return max
end

# Let's try this out – play around with the numbers!

foo(0)
foo(0.1+0.5im)

# Let's apply foo to a grid of numbers. Don't worry too much if you don't
# understand this code, but make sure to evaluate it. (Bonus points for
# using that Ctrl-D trick here, though)

foo(x, y) = foo(x + y*im)

foo_grid(n) =
  broadcast(foo,
            linspace(-0.5, 1, n)',
            linspace(-1, 0.5, n))

# Can you see the pattern?

foo_grid(10)

# Let's try it as an image:

convert(Image, scale(foo_grid(500), 1/80))

# It's a Julia set, of course!

# If you expand the image you can also click on the `Dictionary`
# field to see some interesting properties about it (if that's the
# kind of thing that floats your goat).

# If you want to learn more about Julia, take a look at
# http://julialang.org/learning/

# There is also the Julia manual and the Juno documentation, both
# of which are available from the help menu above.

# Enjoy!
