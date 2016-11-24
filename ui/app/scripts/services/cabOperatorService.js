(function () {
  "use strict";
  angular.module('findACab')
    .factory('cabOperatorService', function ($resource) {

      function getOperators() {
        var operators = [
          {"id": 1,
            "name": "OLA"
          },
          {"id": 2,
            "name": "UBER"
          },
          {"id": 3,
            "name": "TAXI FOR SURE"
          },
          {"id": 4,
            "name": "RELIANCE"
          }];
        return operators;
      }
      return {
        getOperators: getOperators
      }
    });
}());
