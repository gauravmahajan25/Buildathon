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

    .run(function($location ,$rootScope) {
      var port = $location.port();
      //var port ="9090"; //local
      $rootScope.apiPath =  $location.protocol()+ "://"+ $location.host()+":"+ port +"/chooseacab/api";
    })

    .config(function ($routeProvider) {

      $routeProvider
        .when('/', {
          templateUrl: 'views/cabList.html',
          controller: 'CabListController',
          controllerAs: 'list'
        })
        .otherwise({
                     redirectTo: '/'
                   });
    });

}());
