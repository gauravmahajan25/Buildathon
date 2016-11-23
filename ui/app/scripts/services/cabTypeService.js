(function () {
  "use strict";
  angular.module('findACab')
    .factory('cabTypeService', function () {

      function getTypes() {
        var types = [
          {"id": 1,
            "name": "SUV"
          },
          {"id": 2,
            "name": "SEDAN"
          },
          {"id": 3,
            "name": "HATCHBACK"
          },
          {"id": 4,
            "name": "MUV"
          }];
          return types;
       }
      return {
        getTypes: getTypes
      }
    });
}());
