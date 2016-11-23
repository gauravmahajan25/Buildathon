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
    console.log("Entered..............");
    $scope.searchCabs = function (search) {
      console.log("Search..............");
      cabService.get(search,
                     function (resp) {
                       $scope.cabsList = resp.cabs;
                     });

    };
  }
}());
