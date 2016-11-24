(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("cabOperatorService",
             ["$resource",
              cabOperatorService]);

  function cabOperatorService($resource) {
    return $resource("http://localhost:9090/chooseacab/api/operator")
  }

}());

