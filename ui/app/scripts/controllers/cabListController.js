(function () {
  "use strict";
  angular.module("findACab")
    .controller("CabListController",
                ["$scope","cabService","cabTypeService","cabOperatorService","locationService",
                 CabListController]);


  function CabListController($scope,cabService,cabTypeService,cabOperatorService,locationService) {
    $scope.search = {};
    $scope.cabTypes = cabTypeService.getTypes();
    $scope.cabOperators = cabOperatorService.getOperators();
    locationService.query(function(data) {
      $scope.locations = data;
    });
    $scope.searchCabs = function (search) {
      cabService.get(search,
                     function (resp) {
                       $scope.cabsList = resp.cabs;
                     });

    };
  }
}());
