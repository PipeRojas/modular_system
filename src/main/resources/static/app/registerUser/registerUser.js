'use strict';

angular.module('myApp.registerUser', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registerUser', {
    templateUrl: 'registerUser/registerUser.html',
    controller: 'registerUserCtrl'
  });
}])

.controller('registerUserCtrl', ['bcrypt', 'accounts', 'users', 'modules', 'userByName', '$scope','$rootScope','$http','$location', function(bcrypt, accounts, users, modules, userByName, $scope, $rootScope, $http, $location) {
    $scope.userName='';
    $scope.userSelection='';
    $scope.userText='';
    $scope.userPassword='';
    $scope.passwordConfirm='';

    $scope.userSelectionOpt = {
        availableOptions: [
            {id: '0', name: $rootScope.userSelectionOpt1Lng},
            {id: '1', name: $rootScope.userSelectionOpt2Lng},
            {id: '2', name: $rootScope.userSelectionOpt3Lng},
            {id: '3', name: $rootScope.userSelectionOpt4Lng}
        ]
    };

    $scope.registerNewUser=function(){
        $scope.validData=true;
        $scope.validData=$scope.validData&&$scope.userName!='';
        $scope.validData=$scope.validData&&$scope.userText!='';
        $scope.validData=$scope.validData&&$scope.userSelection!='';

        $scope.validPassword=true;
        $scope.validPassword=$scope.validPassword&&$scope.userPassword===$scope.passwordConfirm;

        if($scope.validPassword){
            if($scope.validData){
                $scope.newUser={
                    "name":$scope.userName,
                    "text":$scope.userText,
                    "selection":$scope.userSelection
                };

                users.save($scope.newUser,function(){})
                .$promise.then(
                   //success
                   function( value ){
                        $scope.salt = bcrypt.genSaltSync(10);
                        $scope.hash = bcrypt.hashSync("$scope.userPassword", $scope.salt);

                        $scope.newAccount={
                            "username":$scope.userName,
                            "password":$scope.hash
                        };
                        accounts.save($scope.newAccount,function(){})
                        .$promise.then(
                           //success
                           function( value ){
                                alert($rootScope.saveUserSuccessLng);
                                $location.path("/loginView");
                           },
                           //error
                           function( error ){
                                alert($rootScope.saveUserFailedLng);
                           }
                        );
                   },
                   //error
                   function( error ){
                        alert($rootScope.saveUserFailedLng);
                   }
                );
            }else{
                alert($rootScope.invalidDataLng);
            };
        }else{
            alert($rootScope.passwordDontMatchLng);
        };

    };
}]);