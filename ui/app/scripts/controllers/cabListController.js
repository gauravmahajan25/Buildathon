(function () {
  "use strict";
  angular.module("findACab")
    .controller("CabListController",
                ["$scope", "cabService", "cabTypeService", "cabOperatorService", "locationService",
                 CabListController]);

  function CabListController($scope, cabService, cabTypeService, cabOperatorService,
                             locationService) {
    $scope.search = {};
    $scope.cabList = [];

    cabTypeService.query(function (data) {
      $scope.cabTypes = data;
    });

    cabOperatorService.query(function (data) {
      $scope.cabOperators = data;
    });

    locationService.query(function (data) {
      $scope.locations = data;
    });

    $scope.searchCabs = function (searchForm) {
      $scope.cabList = [];

      if(!validate(searchForm)) return;

      $scope.triggerSearch = true;

      cabService.query($scope.search,
                       function (resp) {
                         $scope.cabList = resp;
                       },
                       function (error) {
                       });

    };

    function validate(searchForm) {
      if(searchForm.$invalid) {
        return false;
      }
      if( $scope.search.sourceId == $scope.search.destinationId) {
        return false;
      }

      return true;
    }
  }
}());
