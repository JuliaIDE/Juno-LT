Jupiter
=======

Jupiter is an environment for the Julia language, with strong support for interactive development and a whole load of other niceties. It's implemented on top of Light Table, using the [Jewel](http://github.com/one-more-minute/Jewel-LT) plugin and a set of great defaults for Julia development.

![Screenshot](screenshot.png)

## Instructions

Note: to execute commands, `Ctrl+Space` the type the command's name.

* Install the plugin with Light Table's plugin manager ("show plugin manager" command, search for "Jupiter").

* Either make sure `julia` is on your path or set the :app behaviour `(:lt.objs.langs.julia/julia-path "/path/to/julia")`.
  * (Use the "user behaviors" command. See [here](https://gist.github.com/one-more-minute/9882389) for an example of setting the Julia path)

* Now restart LT. You should see a working indicator as the Julia client boots up – this may take a while the first time. Use the "toggle console" command to see output.

* Open a `.jl` file (or press `Ctrl-n` for a new one), type something, `Ctrl+Enter` to evaluate the line.

When an update is available, first `Pkg.update()` in Julia, then use the "update all outdated" command in Light Table.

# Useful Shortcuts

`C` = `Ctrl` (Windows, Linux), `Cmd` (OS X)

* `Ctrl-d`: Toggle docs
* `Ctrl-m`: Toggle methods
* `C-;`: Show autocomplete
* `C-/`: Toggle comments
* `C-Enter`: Evaluate current block
* `C-Shift-Enter`: Evaluate whole file
