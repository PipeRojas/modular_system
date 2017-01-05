'use strict';

angular.module('myApp.mainModules', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mainModules', {
    templateUrl: 'mainModules/mainModules.html',
    controller: 'mainModulesCtrl'
  });
}])

.controller('mainModulesCtrl', ['mainModules' , '$scope', '$rootScope', '$location', function(mainModules, $scope, $rootScope, $location) {
    mainModules.get()
    .$promise.then(
        //success
        function( value ){
            $scope.moduleIsSelected=false;
            $scope.mainModulesList=value;
            $rootScope.selectedModule;
            $scope.selectModule=function(module){
                $rootScope.selectedModule=module;
                $scope.moduleIsSelected=true;
            };
            $scope.goToSelectedModule=function(){
                $location.path("/moduleView");
            };
        },
        //error
        function( error ){

        }
    );
}]);