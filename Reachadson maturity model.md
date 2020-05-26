
# Richardson maturity model

This model explains how a micro serices should be written and what practices should that service adhere to. 
Rechardson maturity modesl has categorised these practices into four levels.


* Level 0 - Its say, expose SOAP services in REST styles, means services should be exposed like 
`http://server/getPosts` or `http://server/deletePosts` etc..
* Level 1 - Expose resources with proper URI, like `http://server/accounts` or `http://server/accounts/5`
* Level 2 - Level1 + http verb resources should be accessible with appropriate http verbs
* Level 3 - Level2 + HATEOAS(hyper media as the engine of application state) i.e `Data` along with addional on information of next possible action
