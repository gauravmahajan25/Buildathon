(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("cabTypeService",
             ["$resource",
              cabTypeService]);

  function cabTypeService($resource) {
    return $resource("http://localhost:9090/chooseacab/api/type")
  }

}());
