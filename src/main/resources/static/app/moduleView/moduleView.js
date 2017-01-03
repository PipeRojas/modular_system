'use strict';

angular.module('myApp.moduleView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/moduleView', {
    templateUrl: 'moduleView/moduleView.html',
    controller: 'moduleViewCtrl'
  });
}])

.controller('moduleViewCtrl', [function() {

}]);