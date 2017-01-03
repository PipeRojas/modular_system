'use strict';

angular.module('myApp.moduleView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/moduleView', {
    templateUrl: 'moduleView/moduleView.html',
    controller: 'moduleViewCtrl'
  });
}])

.controller('moduleViewCtrl', ['getModuleByName', '$scope', '$rootScope', '$location', '$window', function(getModuleByName, $scope, $rootScope, $location, $window) {
    $scope.visibleStartDocuments=false;
    $scope.visibleDevelopmentDocuments=false;
    $scope.visibleSubmodules=false;
    $scope.SubModuleIsSelected=false;

    $scope.showStartDocuments=function(){
        $scope.visibleStartDocuments=!$scope.visibleStartDocuments;
    };

    $scope.showDevelopmentDocuments=function(){
        $scope.visibleDevelopmentDocuments=!$scope.visibleDevelopmentDocuments;
    };

    $scope.showSubmodules=function(){
        $scope.visibleSubmodules=!$scope.visibleSubmodules;
    };

    $scope.selectSubModule=function(module){
        $scope.selectedSubModule=module;
        $scope.SubModuleIsSelected=true;
    };

    $scope.goToSubmodule=function(){
        getModuleByName.get({moduleName:$scope.selectedSubModule.name})
        .$promise.then(
           //success
           function( value ){
               console.info(value);
               $scope.SubModuleIsSelected=false;
               $rootScope.selectedModule=value;
               $scope.showSubmodules();
               $scope.goToSelectedModule=function(){
                   $location.path("/moduleView");
               };
           },
           //error
           function( error ){

           }
        );
    };

    $scope.goToDocument=function(documentUri){
        $window.open("https://docs.google.com/viewer?url="+documentUri, '_blank');
    };
}]);