'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])

.factory('mainModules', function($resource) {
     return $resource('/modules/mainModules',{},
     { get: { method: 'GET', isArray: false}});
 });