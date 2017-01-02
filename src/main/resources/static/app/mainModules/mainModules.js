'use strict';

angular.module('myApp.mainModules', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mainModules', {
    templateUrl: 'mainModules/mainModules.html',
    controller: 'mainModulesCtrl'
  });
}])

.controller('mainModulesCtrl', [function() {

}]);