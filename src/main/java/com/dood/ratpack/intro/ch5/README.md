# Handlers
handlers appear to be the stuff that do the work, and can be composed, ie a handler can delegate to another handler
and a handler doesn't actually have to be an endpoint, ie return an httpResponse.

ATM I do not now if a handler is a singleton, where thread safety is important.

Router uses BarHandler and FooHandler, and delegates to one or the other based upon the url path
(look at the get, context.insert of the handler)
Once a delegation chain is at the end, it appears if there are no others that return a valid response,
an internal default that generates a pretty 404 error page (it warns only during dev you will see it)

Order of ops.  Note I renamed some of the classes to make them a bit more clearer
1.  Router, and runRouter
1.  PrintThenNextApplication and RunPrintThenNextApplication
1.  PrintThenInsertOrNextApplication and RunPrintThenInsertOrNextApplication
1.  RouterChain and RunRouterChain