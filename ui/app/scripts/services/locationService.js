(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("locationService",
             ["$resource",
              locationService]);

  function locationService($resource) {
    return $resource("http://localhost:9090/chooseacab/api/location")
  }

}());
