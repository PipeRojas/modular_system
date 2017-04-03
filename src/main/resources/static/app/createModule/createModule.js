'use strict';

angular.module('myApp.createModule', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createModule', {
    templateUrl: 'createModule/createModule.html',
    controller: 'createModuleCtrl'
  });
}])

.controller('createModuleCtrl', ['modules', 'userByName', '$scope','$rootScope','$http','$location', function(modules, userByName, $scope, $rootScope, $http, $location) {
    $scope.moduleName='';
    $scope.moduleOwnerName='';
    $scope.moduleInitialDate='';
    $scope.moduleStartText='';
    $scope.moduleStartSelection='';
    $scope.moduleMaintainsFrequency='';
    $scope.moduleEstimatedDate='';
    $scope.intervalDays='';

    $scope.registerNewModule=function(){

        //Validate data
        $scope.validData=true;
        $scope.validData=$scope.validData&&$scope.moduleName!='';
        $scope.validData=$scope.validData&&$scope.moduleOwnerName!='';
        $scope.validData=$scope.validData&&$scope.moduleInitialDate;
        $scope.validData=$scope.validData&&$scope.moduleStartText!='';
        $scope.validData=$scope.validData&&$scope.moduleStartSelection!='';
        $scope.validData=$scope.validData&&$scope.moduleMaintainsFrequency!='';

        if($scope.moduleMaintainsFrequency==1){
            $scope.validData=$scope.validData&&$scope.intervalDays!='';
            if($scope.validData){
                $scope.validData=$scope.validData&&$scope.intervalDays>0;
                if($scope.validData){
                    var iniDate=new Date($scope.moduleInitialDate);
                    var estDate=new Date(iniDate);
                    estDate.setDate(estDate.getDate()+$scope.intervalDays);
                    $scope.moduleEstimatedDate=estDate;
                }else{
                    alert($rootScope.wrongFrequencyLng);
                }
            }
        }else if($scope.moduleMaintainsFrequency==0){
            $scope.validData=$scope.validData&&$scope.moduleEstimatedDate;
        }
        if($scope.validData){
            userByName.get({userName:$scope.moduleOwnerName})
            .$promise.then(
               //success
               function( value ){
                    $scope.newModuleStart={
                        "text":$scope.moduleStartText,
                        "selection":$scope.moduleStartSelection,
                        "frequency":($scope.moduleMaintainsFrequency==1)?true:false,
                        "estimateDate":$scope.moduleEstimatedDate
                    };
                    $scope.newModuleDevelopment={
                        "text":'',
                        "selection":'',
                        "subModules":[]
                    };
                    $scope.newModuleEnd={
                        "text":'',
                        "selection":'',
                        "startAndDevelopmentRemarks":'',
                        "finalDate":''
                    };
                    $scope.newModule={
                        "name":$scope.moduleName,
                        "owner":value,
                        "start":$scope.newModuleStart,
                        "initialDate":$scope.moduleInitialDate,
                        "development":$scope.newModuleDevelopment,
                        "end":$scope.newModuleEnd,
                        "iteration":false
                    };

                    modules.save($scope.newModule,function(){})
                    .$promise.then(
                       //success
                       function( value ){
                            alert($rootScope.moduleSavedLng);
                            $rootScope.selectedModule=$scope.newModule;
                            $location.path("/moduleView");
                       },
                       //error
                       function( error ){
                            alert($rootScope.errorSavingModuleLng);
                       }
                    );

               },
               //error
               function( error ){
                    alert($rootScope.userDoesntExistLng);
               }
            );
        }else{
            alert($rootScope.invalidDataLng);
        }

    };

    $scope.moduleBooleanOpt = {
        availableOptions: [
            {id: '1', name: $rootScope.YesLng},
            {id: '0', name: $rootScope.NoLng}
        ]
    };

    $scope.moduleStartSelectionOpt = {
        availableOptions: [
            {id: '0', name: $rootScope.createModuleStartSelectionOpt1Lng},
            {id: '1', name: $rootScope.createModuleStartSelectionOpt2Lng},
            {id: '2', name: $rootScope.createModuleStartSelectionOpt3Lng},
            {id: '3', name: $rootScope.createModuleStartSelectionOpt4Lng},
            {id: '4', name: $rootScope.createModuleStartSelectionOpt5Lng},
            {id: '5', name: $rootScope.createModuleStartSelectionOpt6Lng},
            {id: '6', name: $rootScope.createModuleStartSelectionOpt7Lng}
        ]
    };
}]);