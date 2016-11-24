(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("locationService",
             ["$resource","$rootScope",
              locationService]);

  function locationService($resource, $rootScope) {
    return $resource($rootScope.apiPath + "/location")
  }

}());
