## Richardson maturity model

This model explains how a micro serices should be written and what practices should that service adhere to. 
Rechardson maturity modesl has categorised these practices into four levels.


* Level 0 - Its say, expose SOAP services in REST styles. It means services should be exposed in given style 
`http://server/getPosts` or `http://server/deletePosts` etc.
* Level 1 - Expose resources with proper URI. For example `http://server/accounts` or `http://server/accounts/5`
* Level 2 - Level1 + http verb. Resources should be accessible with appropriate `http` verbs.
* Level 3 - Level2 + HATEOAS (hyper media as the engine of application state).`Data` along with addional on information of next possible action.



## Best Practices

* Cosumer First. Any api is eassy to use if the provided documentation is crips and clear. Make sure consumer uderstand the documentation that your produce.
* Make best use of HTTP.
* Proper Request Methods, use GET, POST, PUT , DELETE, DIPATCH etc.. appropriately.
* Proper response status code. For example,when a resource is being created status code should be `201`. If resource is not found it should be `404` or for unaunthorize access it should be `401` and so on.
* Use Plurals i,e prefer using `users` to `user`, or `users/1` to `user/1` etc..
* Use `Noun` when we talk about resources but sometimes it may not possible to use `noun` e.g `/search` or `user/search/` etc all such exceptional scenarios.

