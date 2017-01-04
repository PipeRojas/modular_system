'use strict';

angular.module('myApp.createModule', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/createModule', {
    templateUrl: 'createModule/createModule.html',
    controller: 'createModuleCtrl'
  });
}])

.controller('createModuleCtrl', ['modules', 'getUserByName', '$scope','$rootScope','$http','$location', function(modules, getUserByName, $scope, $rootScope, $http, $location) {
    $scope.moduleName='';
    $scope.moduleOwnerName='';
    $scope.moduleInitialDate='';
    $scope.moduleStartText='';
    $scope.moduleStartSelection='';
    $scope.moduleMaintainsFrequency='';
    $scope.moduleEstimatedDate='';

    $scope.registerNewModule=function(){

        //Validate data
        $scope.validData=true;
        $scope.validData=$scope.validData&&$scope.moduleName!='';
        $scope.validData=$scope.validData&&$scope.moduleOwnerName!='';
        $scope.validData=$scope.validData&&$scope.moduleInitialDate!=null;
        $scope.validData=$scope.validData&&$scope.moduleStartText!='';
        $scope.validData=$scope.validData&&$scope.moduleStartSelection!='';
        $scope.validData=$scope.validData&&$scope.moduleMaintainsFrequency!='';
        $scope.validData=$scope.validData&&$scope.moduleEstimatedDate!=null;

        if($scope.validData){
            getUserByName.get({userName:$scope.moduleOwnerName})
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
                        "selection":''
                    };
                    $scope.newModule={
                        "name":$scope.moduleName,
                        "owner":value,
                        "start":$scope.newModuleStart,
                        "initialDate":$scope.moduleInitialDate,
                        "development":$scope.newModuleDevelopment,
                        "end":$scope.newModuleEnd
                    };
                    modules.save($scope.newModule,function(){});
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
            {id: '3', name: $rootScope.createModuleStartSelectionOpt4Lng}
        ]
    };
}]);