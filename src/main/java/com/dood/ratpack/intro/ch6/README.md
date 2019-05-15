# Context
A core piece of ratpack.  The API doc has a great overview
https://ratpack.io/manual/current/api/ratpack/handling/Context.html

tldr:
1.  access to the http request and response
1.  Handler delegation 
1.  access to objects attached to the context
1.  Convienience for common handler ops

the Context IS a registry of objects, that can be accessed by child handlers

The example in RunApplication shows a way to use the test framework to run the app and test stuff