'use strict';

angular.module('myApp.moduleView', ['ngRoute', 'ngDropzone'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/moduleView', {
    templateUrl: 'moduleView/moduleView.html',
    controller: 'moduleViewCtrl'
  });
}])

.controller('moduleViewCtrl', ['userByName', 'moduleRemark', 'modules', 'subModule', 'moduleByName', '$scope', '$rootScope', '$location', '$window', function(userByName, moduleRemark, modules, subModule, moduleByName, $scope, $rootScope, $location, $window) {
    $scope.visibleStartDocuments=false;
    $scope.visibleDevelopmentDocuments=false;
    $scope.visibleSubmodules=false;
    $scope.visibleDevelopmentEdit=false;
    $scope.visibleEndEdit=false;
    $scope.SubModuleIsSelected=false;
    $scope.visibleSubmoduleForm=false;
    $scope.visibleCloneForm=false;
    $scope.visibleIterateModule=false;
    $scope.tempDevelopmentText='';
    $scope.tempDevelopmentSelection='';
    $scope.tempEndText='';
    $scope.tempEndSelection='';
    $scope.tempEndFinalDate='';
    $scope.tempEndStaDevRemarks='';
    $scope.tempIteration='';
    $scope.newSubModuleName='';
    $scope.newSubModuleDate='';
    $scope.intervalDays='';

    $scope.calculateDays=function(){
        $scope.intervalDays=($rootScope.selectedModule.start.estimateDate-$rootScope.selectedModule.initialDate)/(1000*60*60*24);
    };

    $scope.showIterateForm=function(){
        $scope.visibleIterateModule=!$scope.visibleIterateModule;
    };

    $scope.iterateModule=function(){
        $scope.showIterateForm();
        $scope.prepareCloneModule();
    };


    $scope.saveRemark=function(){
        if($scope.newRemark){
            moduleRemark.update({moduleName:$rootScope.selectedModule.name}, $scope.newRemark)
            .$promise.then(
                 //success
                 function( value ){
                      moduleByName.get({moduleName:$rootScope.selectedModule.name})
                      .$promise.then(
                            //success
                            function( value ){
                                $rootScope.selectedModule=value;
                                $scope.newRemark='';
                                alert($rootScope.newRemarkSavedLng);
                            },
                            //error
                            function( error ){
                                alert($rootScope.errorSavingChangesLng);
                            }
                      );
                 },
                 //error
                 function( error ){
                      alert($rootScope.errorSavingChangesLng);
                 }
            );
        }else{
            alert($rootScope.remarkNotEmptyLng);
        };
    };

    $scope.showSubModuleForm=function(){
        $scope.visibleSubmoduleForm=!$scope.visibleSubmoduleForm;
    };

    $scope.showCloneForm=function(){
        $scope.visibleCloneForm=!$scope.visibleCloneForm;
    };

    $scope.registerModuleClone=function(){
        $scope.validCloneData=true;
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneName!='';
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneOwner!='';
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneInitialDate;
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneStartText!='';
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneStartSelection!='';
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneMaintainsFrequency!='';
        $scope.validCloneData=$scope.validCloneData&&$scope.moduleCloneEstimatedDate;

        if($scope.moduleCloneMaintainsFrequency==1){
            $scope.validData=$scope.validData&&$scope.intervalDays!='';
            if($scope.validData){
                $scope.validData=$scope.validData&&$scope.intervalDays>0;
                if($scope.validData){
                    var iniDate=new Date($scope.moduleCloneInitialDate);
                    var estDate=new Date(iniDate);
                    estDate.setDate(estDate.getDate()+$scope.intervalDays);
                    $scope.moduleCloneEstimatedDate=estDate;
                }else{
                    alert($rootScope.wrongFrequencyLng);
                }
            }
        }else if($scope.moduleCloneMaintainsFrequency==0){
            $scope.validData=$scope.validData&&$scope.moduleCloneEstimatedDate;
        }


        if($scope.validCloneData){
            userByName.get({userName:$scope.moduleCloneOwner.name})
            .$promise.then(
               //success
               function( value ){
                    $scope.moduleCloneOwner=value;
                    $scope.newCloneStart={
                        "text":$scope.moduleCloneStartText,
                        "selection":$scope.moduleCloneStartSelection,
                        "frequency":($scope.moduleCloneMaintainsFrequency==1)?true:false,
                        "documents":$rootScope.selectedModule.start.documents,
                        "estimateDate":$scope.moduleCloneEstimatedDate
                    };
                    $scope.newCloneDevelopment={
                        "text":'',
                        "selection":'',
                        "subModules":[],
                        "documents":[]
                    };
                    $scope.newCloneEnd={
                        "text":'',
                        "selection":'',
                        "startAndDevelopmentRemarks":'',
                        "finalDate":''
                    };
                    $scope.newClone={
                        "name":$scope.moduleCloneName,
                        "owner":$scope.moduleCloneOwner,
                        "start":$scope.newCloneStart,
                        "initialDate":$scope.moduleCloneInitialDate,
                        "development":$scope.newCloneDevelopment,
                        "end":$scope.newCloneEnd,
                        "iteration":false
                    };


                    modules.save($scope.newClone)
                    .$promise.then(
                         //success
                         function( value ){
                              alert($rootScope.changesSavedLng);
                              moduleByName.get({moduleName:$scope.newClone.name})
                              .$promise.then(
                                    //success
                                    function( value ){
                                        $rootScope.selectedModule=value;
                                        $scope.showCloneForm();
                                    },
                                    //error
                                    function( error ){
                                        alert($rootScope.errorSavingModuleLng);
                                    }
                              );
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
        };
    };
    
    $scope.prepareCloneModule=function(){
        $scope.moduleCloneName=$rootScope.selectedModule.name;
        $scope.moduleCloneOwner=$rootScope.selectedModule.owner;
        $scope.moduleCloneInitialDate=new Date($rootScope.selectedModule.initialDate);
        $scope.moduleCloneStartText=$rootScope.selectedModule.start.text;
        $scope.moduleCloneStartSelection=$rootScope.selectedModule.start.selection;
        $scope.moduleCloneMaintainsFrequency=$rootScope.selectedModule.start.frequency;
        $scope.moduleCloneEstimatedDate=new Date($rootScope.selectedModule.start.estimateDate);

        $scope.newCloneStart={
            "text":$scope.moduleCloneStartText,
            "selection":$scope.moduleCloneStartSelection,
            "frequency":($scope.moduleCloneMaintainsFrequency==1)?true:false,
            "documents":$rootScope.selectedModule.start.documents,
            "estimateDate":$scope.moduleCloneEstimatedDate
        };
        $scope.newCloneDevelopment={
            "text":'',
            "selection":'',
            "subModules":[],
            "documents":[]
        };
        $scope.newCloneEnd={
            "text":'',
            "selection":'',
            "startAndDevelopmentRemarks":'',
            "finalDate":''
        };
        $scope.newClone={
            "name":$scope.moduleCloneName,
            "owner":$scope.moduleCloneOwner,
            "start":$scope.newCloneStart,
            "initialDate":$scope.moduleCloneInitialDate,
            "development":$scope.newCloneDevelopment,
            "end":$scope.newCloneEnd,
            "iteration":false
        };
        $scope.showCloneForm();
    };
    
    
    $scope.registerNewSubModule=function(){
        $scope.validSubModuleData=true;
        $scope.validSubModuleData=$scope.validSubModuleData&&$scope.newSubModuleName!='';
        $scope.validSubModuleData=$scope.validSubModuleData&&$scope.newSubModuleDate;

        if($scope.validSubModuleData){
            $scope.newSubModuleStart={
                "text":$rootScope.selectedModule.start.text,
                "selection":$rootScope.selectedModule.start.selection,
                "frequency":$rootScope.selectedModule.start.frequency,
                "documents":$rootScope.selectedModule.start.documents,
                "estimateDate":$scope.newSubModuleDate
            };
            $scope.newSubModuleDevelopment={
                "text":'',
                "selection":'',
                "subModules":[],
                "documents":[]
            };
            $scope.newSubModuleEnd={
                "text":'',
                "selection":'',
                "startAndDevelopmentRemarks":'',
                "finalDate":''
            };
            $scope.newSubModule={
                "name":$scope.newSubModuleName,
                "owner":$rootScope.selectedModule.owner,
                "start":$scope.newSubModuleStart,
                "initialDate":$rootScope.selectedModule.initialDate,
                "development":$scope.newSubModuleDevelopment,
                "end":$scope.newSubModuleEnd,
                "iteration":''
            };


            subModule.update({moduleName:$rootScope.selectedModule.name}, $scope.newSubModule)
            .$promise.then(
                 //success
                 function( value ){
                      alert($rootScope.changesSavedLng);
                      moduleByName.get({moduleName:$scope.newSubModule.name})
                      .$promise.then(
                            //success
                            function( value ){
                                moduleByName.get({moduleName:$rootScope.selectedModule.name})
                                .$promise.then(
                                    //success
                                    function( value ){
                                         $rootScope.selectedModule=value;
                                         $scope.showSubModuleForm();
                                    },
                                    //error
                                    function( error ){
                                        alert($rootScope.errorSavingChangesLng);
                                    }
                                );
                            },
                            //error
                            function( error ){
                                alert($rootScope.errorSavingChangesLng);
                            }
                      );
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

    $scope.moduleStartSelectionOpt = {
        availableOptions: [
            {id: '0', name: $rootScope.createModuleStartSelectionOpt1Lng},
            {id: '1', name: $rootScope.createModuleStartSelectionOpt2Lng},
            {id: '2', name: $rootScope.createModuleStartSelectionOpt3Lng},
            {id: '3', name: $rootScope.createModuleStartSelectionOpt4Lng}
        ]
    };

    $scope.moduleBooleanOpt = {
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
        $scope.validEndData=$scope.validEndData&&$scope.tempEndFinalDate;
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
                    if($rootScope.selectedModule.iteration){
                        $scope.showIterateForm();
                    };
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

    $scope.showSubmodules();
    $scope.calculateDays();
}]);