(function () {
  "use strict";
  angular.module("findACab")
    .controller("CabListController",
                ["$scope","cabService","cabTypeService","cabOperatorService",
                 CabListController]);


  function CabListController($scope,cabService,cabTypeService,cabOperatorService) {
    $scope.search = {};
    $scope.cabTypes = cabTypeService.getTypes();
    $scope.cabOperators = cabOperatorService.getOperators();
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
