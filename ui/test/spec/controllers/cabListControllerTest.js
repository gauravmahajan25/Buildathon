describe('Controller: CabListController', function () {
  var mockCabService = {};
  var ctrl, scope;

  beforeEach(function () {

    module('findACab', function ($provide) {
      $provide.value('cabService', mockCabService);
      $provide.value('cabTypeService', mockCabTypeService);
      $provide.value('cabOperatorService', mockCabOperatorService);
      $provide.value('locationService', mockLocationService);
    });

    inject(function ($q) {
        mockCabService.search = function () {
          var defer = $q.defer();
          defer.resolve([{
            "id": 100,
            "operatorName": "OLA",
            "typeName": "SEDAN",
            "fair": 10.0,
            "discount": null
          }]);
          return defer.promise;
        };

        mockCabServiceabTypeService.search = function () {
          var defer = $q.defer();
          defer.resolve([{
            "id": 101,
            "name": "HATCHBACK"
          }, {
            "id": 102,
            "name": "MUV"
          }, {
            "id": 100,
            "name": "SEDAN"
          }]);
          return defer.promise;
        };

        mockCabOperatorService.search = function () {
          var defer = $q.defer();
          defer.resolve([{
            "id": 100,
            "name": "MERU"
          }, {
            "id": 102,
            "name": "OLA"
          }, {
            "id": 101,
            "name": "UBER"
          }]);
          return defer.promise;
        };

        mockLocationService.search = function () {
          var defer = $q.defer();
          defer.resolve([{
            "id": 100,
            "name": "HYDERABAD",
            "zipCode": 500001
          }, {
            "id": 101,
            "name": "BANGLORE",
            "zipCode": 560001
          }]);
          return defer.promise;
        };
      }


    );
  });


  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ctrl = $controller('CabListController', {
      $scope: scope,
      cabService: mockCabService,
      cabTypeService: mockCabTypeService,
      cabOperatorService: mockCabOperatorService,
      locationService: mockLocationService
    });
  }));

  it('should search for the cabs with serch criteria', function () {

    search = {
      sourceId: "source",
      destinationId: "dest"
    };

    //scope.searchCabs();
    //expect($scope.cabList.length).toBe(3);
  });
});