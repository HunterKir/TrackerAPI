# TrackerAPI
A simple RESTful API that keeps track of keys that are pressed. The user will be able to create presets that track whichever buttons they want using the simple application included.

The actual keylogger is a program that listens for keypresses, mouse movement, and mouse clicks. It connects to a mySQL database hosted on an AWS server and stores all data that you want to track. JavaFX is used to render the program's simple GUI in which the user can log into an account, select or create a preset to use, and run the global key listeners to track the specific key presses.
