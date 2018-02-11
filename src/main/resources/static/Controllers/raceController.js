app.controller('raceController', function($scope, $http, $location, myFactory){


    $scope.$watch('$viewContentLoaded', function() {
        $scope.showAvailableRaces();
    });

$scope.userId=myFactory.getUser();



$scope.showAvailableRaces = function() {

    $http.get($location.protocol() + '://' + $location.host() + ':' + $location.port() + '/race/getAllRaces')
        .then(function (result) {

                $scope.races = result.data;

            }, function (result) {

                $scope.dyscyplines = ["blad zaladowania kategorii"];
            }
        );

};
$scope.signIntoRace = function (raceId) {
    $http.get($location.protocol() + '://' + $location.host() + ':' + $location.port() + '/race/signIntoRace/' + $scope.userId + '/' + raceId)
        .when(function (result) {

        }, function (result) {


        });


};



});