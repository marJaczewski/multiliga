app.controller('adminController', function($scope, $http, $location, myFactory) {

    $scope.race = {
        type: "",
        capacity: "",
        date: "",
        distance: "",
        place: ""
    };

    $scope.dyscyplines = "";

    $scope.loadDyscyplines = function () {
        $http.get($location.protocol() + '://' + $location.host() + ':' + $location.port() + '/user/getAllDyscyplines')
            .then(function (result) {

                    $scope.dyscyplines = result.data;
                    console.log($scope.dyscyplines);
                }, function (result) {

                    $scope.dyscyplines = ["blad zaladowania kategorii"];
                }
            );


    };


    $scope.createNewRace = function () {


        console.log($scope.team);

        //$http.post('http://localhost:8096/team/createNewTeam', $scope.team);
        //$http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/createNewTeam', $scope.team)

        $http.get($location.protocol() + '://' + $location.host() + ':' + $location.port() + '/race/createNewRace/'
            + $scope.race.type + "/"
            + $scope.race.capacity + "/"
            + $scope.race.date+"/"
            + $scope.race.distance+"/"
            + $scope.race.place

        )
            .then(function (result) {

                alert(result.data);
            }, function (result) {
                alert(result.data);

            });


    }
});