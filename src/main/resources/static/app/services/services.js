'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])

.factory('principalModules', function($resource) {
     return $resource('/modules/mainModules',{},
     { get: { method: 'GET', isArray: false}});
 });