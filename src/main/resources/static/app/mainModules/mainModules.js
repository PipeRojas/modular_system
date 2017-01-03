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
            console.info(value);
            $scope.moduleIsSelected=false;
            $scope.mainModulesList=value;
            $scope.selectedModule='';
            $scope.selectModule=function(moduleName){
                $scope.selectedModule=moduleName;
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