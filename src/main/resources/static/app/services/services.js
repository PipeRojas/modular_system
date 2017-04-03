'use strict';

angular.module('services.factory', ['ngRoute', 'ngResource'])

.factory('mainModules', function($resource) {
    return $resource('/modules/mainModules',{},{ get: { method: 'GET', isArray: false}});
})
.factory('mainModulesByUserName', function($resource){
      return $resource('/modules/mainModules/:userName',{id:"@_userName"},{ get: { method: 'GET', isArray: false}});
})
.factory('moduleByName', function($resource){
      return $resource('/modules/:moduleName',{id:"@_moduleName"},{update: { method: 'PUT'}});
})
.factory('userByName', function($resource){
      return $resource('/users/:userName',{id:"@_userName"},{get: { method: 'GET'}});
})
.factory('modules', function($resource){
      return $resource('/modules',{},{get: { method: 'GET'}});
})
.factory('subModule', function($resource){
      return $resource('/modules/subModule/:moduleName',{id:"@_moduleName"},{update: { method: 'PUT'}});
})
.factory('users', function($resource) {
    return $resource('/users',{},{ get: { method: 'GET', isArray: false}});
})
.factory('accounts', function($resource) {
    return $resource('/app/user',{},{ get: { method: 'GET', isArray: false}});
})
.factory('moduleRemark', function($resource) {
    return $resource('/modules/remark/:moduleName',{id:"@_moduleName"},{ update: { method: 'PUT'}});
})
.factory('startDocument', function($resource){
      return $resource('/modules/startDocument/:moduleName',{id:"@_moduleName"},{update: { method: 'PUT', headers: {'Content-Type': 'undefined', 'transformRequest': 'angular.identity'}}});
});