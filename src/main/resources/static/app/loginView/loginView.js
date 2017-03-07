'use strict';

angular.module('myApp.loginView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/loginView', {
    templateUrl: 'loginView/loginView.html',
    controller: 'loginViewCtrl'
  });
}])

.controller('loginViewCtrl', ['$scope','$rootScope','$http','$location', function($scope, $rootScope, $http, $location) {
    var authenticate = function (credentials, callback) {
        var headers = credentials ? {authorization: "Basic "
                    + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('/app/user', {headers: headers}).success(function (data) {
            if (data.name) {
                $rootScope.authenticated = true;
                $rootScope.actualUser = credentials.username;
            } else {
                $rootScope.authenticated = false;
            }
            callback && callback();
        }).error(function () {
            $rootScope.authenticated = false;
            callback && callback();
        });

    };

    authenticate();
    $scope.credentials = {};
    $scope.login = function () {
        authenticate($scope.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path("/view1");
                $scope.error = false;
            } else {
                $location.path("/loginView");
                $scope.error = true;
                alert($rootScope.failedAuthLng);
            }
        });
    };
}]);