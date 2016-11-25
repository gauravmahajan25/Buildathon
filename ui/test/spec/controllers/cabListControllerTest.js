describe('Controller: CabListController', function () {
  var mockCabService = new Object();
  var mockCabTypeService = new Object();
  var mockCabOperatorService = new Object();
  var mockLocationService = new Object();
  var ctrl, scope, timeout;

  beforeEach(function () {
    module('findACab', function ($provide) {
      $provide.value('cabService', mockCabService);
      $provide.value('cabTypeService', mockCabTypeService);
      $provide.value('cabOperatorService', mockCabOperatorService);
      $provide.value('locationService', mockLocationService);
    });

    inject(function ($q) {
             mockCabService.query = function (search, successFn, errorFn) {
               successFn([{
                 "id": 100,
                 "operatorName": "OLA",
                 "typeName": "SEDAN",
                 "fair": 10.0,
                 "discount": null
               }]);
             };

             mockCabTypeService.query = function (successFn) {
               successFn([{
                 "id": 101,
                 "name": "HATCHBACK"
               }, {
                 "id": 102,
                 "name": "MUV"
               }, {
                 "id": 100,
                 "name": "SEDAN"
               }]);
             };

             mockCabOperatorService.query = function (successFn) {
               successFn([{
                 "id": 100,
                 "name": "MERU"
               }, {
                 "id": 102,
                 "name": "OLA"
               }, {
                 "id": 101,
                 "name": "UBER"
               }]);
             };

             mockLocationService.query = function (successFn) {
               successFn([{
                 "id": 100,
                 "name": "HYDERABAD",
                 "zipCode": 500001
               }, {
                 "id": 101,
                 "name": "BANGLORE",
                 "zipCode": 560001
               }]);
             };
           }
    );

  });

  beforeEach(inject(function ($controller, $rootScope, $timeout) {
    scope = $rootScope.$new();
    ctrl = $controller('CabListController', {
      $scope: scope,
      cabService: mockCabService,
      cabTypeService: mockCabTypeService,
      cabOperatorService: mockCabOperatorService,
      locationService: mockLocationService
    });
    timeout = $timeout;
  }));

  it('should search for the cabs with serch criteria', function () {

    search = {
      sourceId: "source",
      destinationId: "dest"
    };

    searchForm = {}
    scope.searchCabs(searchForm);
    timeout(function () {
      expect(scope.cabList.length).toBe(1);
    }, 1000)
  })

  it('should get cab operators from service ', function () {
    timeout(function () {
      expect(scope.cabOperators.length).toBe(3);
    }, 1000)
  });

  it('should get cab types from service ', function () {
    timeout(function () {
      expect(scope.cabTypes.length).toBe(3);
    }, 1000)
  });

  it('should get locations from service ', function () {
    timeout(function () {
      expect(scope.locations.length).toBe(2);
    }, 1000)
  });
});
