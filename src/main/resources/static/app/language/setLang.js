'use strict';

angular.module('language.setting', ['ngRoute'])

.controller('langCtrl', ['$rootScope', '$scope',function($rootScope, $scope) {
    //Add all UI strings here to change language
    $rootScope.logInUserLng="User: ";
    $rootScope.logInPassLng="Password: ";
    $rootScope.logInButtonLng="LogIn";
    $rootScope.logInLng="Log In";
    $rootScope.logOutLng="Log Out";
    $rootScope.mainModulesLng="Main Modules";
    $rootScope.selectOneForDetailsLng="(select one to see details)";
    $rootScope.moduleNameLng="Module Name";
    $rootScope.moduleOwnerLng="Module Owner";
    $rootScope.goToModuleBtnLng="Go to selected module";
    $rootScope.actualModuleLng="Actual Module: ";
    $rootScope.modularSystemTitleLng="Modular System";
    $rootScope.modularSystemVersionLng="App Version: ";
    $rootScope.modularSystemSubTitleLng="Modules Unified Management";
    $rootScope.actualModuleProprietorLng="Module Proprietor: ";
    $rootScope.actualModuleInitialDateLng="Module Initial Date: ";
    $rootScope.moduleStartLng="Module Start";
    $rootScope.moduleStartTextLng="Module Start Text: ";
    $rootScope.moduleStartSelectionLng="Module Start Selection: ";
    $rootScope.moduleMaintainsFrequencyLng="This Module Maintains a Frequency? ";
    $rootScope.YesLng="Yes";
    $rootScope.NoLng="No";
    $rootScope.backLng="Back";
    $rootScope.failedAuthLng="Permission denied: Authentication Failed";
    $rootScope.moduleEstimatedDateLng="Module Estimated Date: ";
    $rootScope.moduleStartDocumentsLng="Module Start Documents";
    $rootScope.moduleDevelopmentLng="Module Development";
    $rootScope.moduleDevelopmentTextLng="Module Development Text: ";
    $rootScope.moduleDevelopmentSelectionLng="Module Development Selection: ";
    $rootScope.moduleDevelopmentDocumentsLng="Module Development Documents";
    $rootScope.moduleSubmodulesLng="Sub-Modules of this Module";
    $rootScope.moduleEndLng="Module End";
    $rootScope.moduleEndTextLng="Module End Text: ";
    $rootScope.moduleEndSelectionLng="Module End Selection: ";
    $rootScope.moduleEndFinalDateLng="Module Final Date: ";
    $rootScope.moduleStartDevelopmentRemarksLng="Module Start & Development Remarks: ";
    $rootScope.moduleIsIterableLng="Module is Iterable? ";
    $rootScope.moduleRemarksLng="Module Remarks";
    $rootScope.createModuleLng="Create New Module";
    $rootScope.createModuleNameLng="Module Name: ";
    $rootScope.createModuleOwnerNameLng="Module Owner Name: ";
    $rootScope.createModuleInitialDateLng="Module Initial Date: ";
    $rootScope.createModuleStartDataLng="Module Start Data";
    $rootScope.createModuleStartTextLng="Module Start Text: ";
    $rootScope.createModuleStartSelectionLng="Module Start Selection: ";
    $rootScope.createModuleStartSelectionOpt1Lng="Start Selection Option 1";
    $rootScope.createModuleStartSelectionOpt2Lng="Start Selection Option 2";
    $rootScope.createModuleStartSelectionOpt3Lng="Start Selection Option 3";
    $rootScope.createModuleStartSelectionOpt4Lng="Start Selection Option 4";
    $rootScope.createModuleMaintainsFrequencyLng="Module Maintains Frequency: ";
    $rootScope.moduleFrequencyNoteLng="Note: If the module has frequency, it will be given by the time between the initial date and the estimated date.";
    $rootScope.createModuleEstimatedDateLng="Module Estimated Date: ";
    $rootScope.registerModuleLng="Register Module";
    $rootScope.invalidDataLng="Invalid Data";
    $rootScope.userDoesntExistLng="The user does not exist in the database";
    $rootScope.errorSavingModuleLng="An error occurred while registering the module, try again later";
    $rootScope.moduleSavedLng="The module was saved successfully";
    $rootScope.changesSavedLng="The changes was made successfully";
    $rootScope.errorSavingChangesLng="An error occurred while registering the changes, try again later";
    $rootScope.saveChangesLng="Save Changes";
    $rootScope.editModuleDevelopmentLng="Edit Module Development";
    $rootScope.moduleDevelopmentSelectionOpt1Lng="Development Selection Option 1";
    $rootScope.moduleDevelopmentSelectionOpt2Lng="Development Selection Option 2";
    $rootScope.moduleDevelopmentSelectionOpt3Lng="Development Selection Option 3";
    $rootScope.moduleDevelopmentSelectionOpt4Lng="Development Selection Option 4";
    $rootScope.editModuleEndLng="Edit Module End";
    $rootScope.moduleEndSelectionOpt1Lng="End Selection Option 1";
    $rootScope.moduleEndSelectionOpt2Lng="End Selection Option 2";
    $rootScope.moduleEndSelectionOpt3Lng="End Selection Option 3";
    $rootScope.moduleEndSelectionOpt4Lng="End Selection Option 4";
    $rootScope.createSubModuleLng="Add New SubModule";
    $rootScope.createSubModuleNameLng="SubModule Name: ";
    $rootScope.createSubModuleEstimatedDateLng="SubModule Estimated Date: ";
    $rootScope.registerNewSubModuleLng="Register SubModule";
 }]);