(function () {
  "use strict";
  angular.module("findACab")
    .controller("CabListController",
                ["$scope","cabService",
                 CabListController]);

  function CabListController($scope,cabService) {
    $scope.search = {};
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
