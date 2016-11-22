(function () {
  "use strict";
  angular.module('findACab')
    .factory('cabService', function ($resource) {
      return $resource("http://free.rome2rio.com/api/1.2/json/Search",
         {
           source: '@source',
           destination: '@destination',
           cabType: '@cabType'
         });
    });
}());
