(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("cabOperatorService",
             ["$resource","$rootScope",
              cabOperatorService]);

  function cabOperatorService($resource, $rootScope) {
    return $resource($rootScope.apiPath + "/operator")
  }

}());

