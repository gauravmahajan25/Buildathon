(function () {
  "use strict";
  var app = angular.module("findACab",
                           [
                             'ngAnimate',
                             'ngCookies',
                             'ngResource',
                             'ngRoute',
                             'ngSanitize',
                             'ngTouch'
    ])
    .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/cabList.html',
        controller: 'CabListController',
        controllerAs: 'list'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .otherwise({
                   redirectTo: '/'
                 });
  });
}());
