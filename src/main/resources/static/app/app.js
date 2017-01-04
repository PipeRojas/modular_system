'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'myApp.loginView',
  'myApp.mainModules',
  'myApp.moduleView',
  'myApp.createModule',
  'services.factory',
  'language.setting',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', '$httpProvider',function($locationProvider, $routeProvider, $httpProvider) {
    $locationProvider.hashPrefix('!');
    $routeProvider.otherwise({redirectTo: '/'});
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])
.controller('LogoutCtrl', ['$rootScope', '$scope', '$http' , '$location',function($rootScope, $scope, $http , $location) {
    $scope.logout = function () {
      $http.post('/logout', {}).success(function () {
          $rootScope.authenticated = false;
          $location.path("/");
      }).error(function (data) {
          $rootScope.authenticated = false;
      });
    };
}]);
