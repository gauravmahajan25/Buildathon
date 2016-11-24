(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("cabTypeService",
             ["$resource","$rootScope",
              cabTypeService]);

  function cabTypeService($resource, $rootScope) {
    return $resource($rootScope.apiPath + "/type")
  }

}());
