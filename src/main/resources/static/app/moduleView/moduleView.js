'use strict';

angular.module('myApp.moduleView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/moduleView', {
    templateUrl: 'moduleView/moduleView.html',
    controller: 'moduleViewCtrl'
  });
}])

.controller('moduleViewCtrl', ['moduleByName', '$scope', '$rootScope', '$location', '$window', function(moduleByName, $scope, $rootScope, $location, $window) {
    $scope.visibleStartDocuments=false;
    $scope.visibleDevelopmentDocuments=false;
    $scope.visibleSubmodules=false;
    $scope.visibleDevelopmentEdit=false;
    $scope.visibleEndEdit=false;
    $scope.SubModuleIsSelected=false;
    $scope.tempDevelopmentText='';
    $scope.tempDevelopmentSelection='';
    $scope.tempEndText='';
    $scope.tempEndSelection='';
    $scope.tempEndFinalDate='';
    $scope.tempEndStaDevRemarks='';
    $scope.tempIteration='';

    $scope.endBooleanOpt = {
        availableOptions: [
            {id: '1', name: $rootScope.YesLng},
            {id: '0', name: $rootScope.NoLng}
        ]
    };

    $scope.moduleEndSelectionOpt = {
        availableOptions: [
            {id: '0', name: $rootScope.moduleEndSelectionOpt1Lng},
            {id: '1', name: $rootScope.moduleEndSelectionOpt2Lng},
            {id: '2', name: $rootScope.moduleEndSelectionOpt3Lng},
            {id: '3', name: $rootScope.moduleEndSelectionOpt4Lng}
        ]
    };

    $scope.saveNewEndData=function(){
        $scope.validEndData=true;
        $scope.validEndData=$scope.validEndData&&$scope.tempEndText!='';
        $scope.validEndData=$scope.validEndData&&$scope.tempEndSelection!='';
        $scope.validEndData=$scope.validEndData&&$scope.tempEndFinalDate!=null;
        $scope.validEndData=$scope.validEndData&&$scope.tempEndStaDevRemarks!='';
        $scope.validEndData=$scope.validEndData&&$scope.tempIteration!='';

        if($scope.validEndData){
            $rootScope.selectedModule.end.text=$scope.tempEndText;
            $rootScope.selectedModule.end.selection=$scope.tempEndSelection;
            $rootScope.selectedModule.end.finalDate=$scope.tempEndFinalDate;
            $rootScope.selectedModule.end.startAndDevelopmentRemarks=$scope.tempEndStaDevRemarks;
            $rootScope.selectedModule.iteration=($scope.tempIteration==1)?true:false;
            moduleByName.update({moduleName:$scope.selectedModule.name}, $rootScope.selectedModule)
            .$promise.then(
               //success
               function( value ){
                    alert($rootScope.changesSavedLng);
                    $scope.showEndEdit();
               },
               //error
               function( error ){
                    alert($rootScope.errorSavingChangesLng);
               }
            );

        }else{
            alert($rootScope.invalidDataLng);
        };
    };

    $scope.saveNewDevelopmentData=function(){
        $scope.validDevelopmentData=true;
        $scope.validDevelopmentData=$scope.validDevelopmentData&&$scope.tempDevelopmentText!='';
        $scope.validDevelopmentData=$scope.validDevelopmentData&&$scope.tempDevelopmentSelection!='';
        if($scope.validDevelopmentData){
            $rootScope.selectedModule.development.text=$scope.tempDevelopmentText;
            $rootScope.selectedModule.development.selection=$scope.tempDevelopmentSelection;
            moduleByName.update({moduleName:$scope.selectedModule.name}, $rootScope.selectedModule)
            .$promise.then(
               //success
               function( value ){
                    alert($rootScope.changesSavedLng);
                    $scope.showDevelopmentEdit();
               },
               //error
               function( error ){
                    alert($rootScope.errorSavingChangesLng);
               }
            );

        }else{
            alert($rootScope.invalidDataLng);
        };
    };

    $scope.moduleDevelopmentSelectionOpt = {
        availableOptions: [
            {id: '0', name: $rootScope.moduleDevelopmentSelectionOpt1Lng},
            {id: '1', name: $rootScope.moduleDevelopmentSelectionOpt2Lng},
            {id: '2', name: $rootScope.moduleDevelopmentSelectionOpt3Lng},
            {id: '3', name: $rootScope.moduleDevelopmentSelectionOpt4Lng}
        ]
    };

    $scope.showEndEdit=function(){
        $scope.tempEndText=$rootScope.selectedModule.end.text;
        $scope.tempEndStaDevRemarks=$rootScope.selectedModule.end.startAndDevelopmentRemarks;
        $scope.visibleEndEdit=!$scope.visibleEndEdit;
    };

    $scope.showDevelopmentEdit=function(){
        $scope.tempDevelopmentText=$rootScope.selectedModule.development.text;
        $scope.visibleDevelopmentEdit=!$scope.visibleDevelopmentEdit;
    };

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
        moduleByName.get({moduleName:$scope.selectedSubModule.name})
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