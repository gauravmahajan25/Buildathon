(function () {
  "use strict";
  angular.module("findACab")
    .controller("CabListController",
                ["$scope","cabService","cabTypeService","cabOperatorService","locationService",
                 CabListController]);


  function CabListController($scope,cabService,cabTypeService,cabOperatorService,locationService) {
    $scope.search = {};
    cabTypeService.query(function(data) {
      $scope.cabTypes = cabTypeService.getTypes();
    });
    cabOperatorService.query(function(data) {
      $scope.cabOperators = cabOperatorService.getOperators();
    });
    locationService.query(function(data) {
      $scope.locations = data;
    });


    $scope.searchCabs = function (search) {

      $scope.submitted = true;
      cabService.search({query: search},
                     function (resp) {
                       $scope.cabsList = resp;
                     });

    };
  }
}());
