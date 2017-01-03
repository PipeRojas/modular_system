'use strict';

angular.module('myApp.moduleView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/moduleView', {
    templateUrl: 'moduleView/moduleView.html',
    controller: 'moduleViewCtrl'
  });
}])

.controller('moduleViewCtrl', ['$scope', '$rootScope', '$location', function($scope, $rootScope, $location) {

}]);