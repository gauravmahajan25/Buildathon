(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("cabService",
             ["$resource",
              cabService]);

  function cabService($resource) {
    return $resource("http://localhost:9090/chooseacab/api/ride-details:query",{query:'@query'},
                                     {
                                       search: {
                                         method: 'GET',
                                         params: {
                                           action: "search",
                                           query: '@query'
                                         }
                                       }
                                     });
  }

}());


