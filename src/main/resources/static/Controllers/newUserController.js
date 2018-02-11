app.controller('newUserController', function($scope, $http, $location, myFactory){


    $scope.user={
      nazwisko:"",
      email:"",
      haslo:""
    };



    $scope.submit_success = false;
    $scope.call = function () {
        $scope.server = angular.copy($scope.user);
        $scope.submit_success = true;


        $http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/free/newUser', $scope.user);

        window.location.href = "#login";
    }


});