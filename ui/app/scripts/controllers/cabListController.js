(function () {
  "use strict";
  angular.module("findACab")
    .controller("CabListController",
                ["$scope", "cabService", "cabTypeService", "cabOperatorService", "locationService","$route",
                 CabListController]);

  function CabListController($scope, cabService, cabTypeService, cabOperatorService,
                             locationService, $route) {
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

    $scope.searchCabs = function (searchForm,search) {
      $scope.cabList = [];

      if(!validate(searchForm)) return;

      $scope.triggerSearch = true;

      cabService.query(search,
                       function (resp) {
                         $scope.cabList = resp;
                       },
                       function (error) {
                       });

    };

    $scope.reset = function(){
      $route.reload();
    }

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
