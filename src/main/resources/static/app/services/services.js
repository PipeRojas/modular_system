'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])

.factory('principalModules', function($resource) {
     return $resource('/parkings',{},
     { get: { method: 'GET', isArray: true}});
 });