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
    $rootScope.failedAuth="Permission denied: Authentication Failed";
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
    $rootScope.moduleStartDevelopmentRemarksLng="Module Start & Development Remarks: ";
    $rootScope.moduleIsIterableLng="Module is Iterable? ";
    $rootScope.moduleRemarksLng="Module Remarks";
 }]);