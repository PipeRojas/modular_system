'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])

.factory('mainModules', function($resource) {
    return $resource('/modules/mainModules',{},{ get: { method: 'GET', isArray: false}});
})
.factory('getModuleByName', function($resource){
      return $resource('/modules/:moduleName',{id:"@_moduleName"},{get: { method: 'GET'}});
});