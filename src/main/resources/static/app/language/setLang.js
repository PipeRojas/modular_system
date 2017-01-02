'use strict';

angular.module('language.setting', ['ngRoute'])

.controller('langCtrl', ['$rootScope', '$scope',function($rootScope, $scope) {
    //Add all UI strings here to change language
   $rootScope.logInLng="Log In";
   $rootScope.logOutLng="Log Out";
   $rootScope.mainModulesLng="Main Modules";
 }]);