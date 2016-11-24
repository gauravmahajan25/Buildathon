(function () {
  "use strict";

  angular
    .module("findACab")
    .factory("cabService",
             ["$resource","$rootScope",
              cabService]);

  function cabService($resource, $rootScope) {
    return $resource($rootScope.apiPath + "/ride-details",
                                     {
                                       sourceId: '@sourceId',
                                       destinationId: '@destinationId',
                                       operatorIds: '@operatorIds',
                                       typeIds:'@typeIds'
                                     });
  }

}());


