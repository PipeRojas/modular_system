'use strict';

angular.module('myApp.mainModules', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/mainModules', {
    templateUrl: 'mainModules/mainModules.html',
    controller: 'mainModulesCtrl'
  });
}])

.controller('mainModulesCtrl', ['mainModulesByUserName', 'moduleByName', 'mainModules' , '$scope', '$rootScope', '$location', function(mainModulesByUserName, moduleByName, mainModules, $scope, $rootScope, $location) {
    mainModulesByUserName.get({userName:$rootScope.actualUser})
    .$promise.then(
        //success
        function( value ){
            $scope.moduleName='';
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
            $scope.loadModuleByName=function(){
                $scope.validData=true;
                $scope.validData=$scope.validData&&$scope.moduleName!='';
                if($scope.validData){
                    moduleByName.get({moduleName:$scope.moduleName})
                    .$promise.then(
                        //success
                        function( value ){
                             $rootScope.selectedModule=value;
                             $location.path("/moduleView");
                        },
                        //error
                        function( error ){
                            alert($rootScope.errorLoadingModuleLng);
                        }
                    );
                }else{
                    alert($rootScope.invalidDataLng);
                }
            };
        },
        //error
        function( error ){
            alert($rootScope.errorLoadingMainModulesLng);
        }
    );
}]);