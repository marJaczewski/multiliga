app.controller('newTeamController', function($scope, $http, $location, myFactory){

$scope.team={
    name:"",
    captainId:"",
    type:""
};
    $scope.team.captainId=myFactory.getUser();
$scope.message="";




$scope.dyscyplines="";

    $scope.loadDyscyplines = function () {
        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/user/getAllDyscyplines')
            .then(function (result) {

                    $scope.dyscyplines = result.data;
                    console.log($scope.dyscyplines);
                }, function (result) {

                    $scope.dyscyplines = ["blad zaladowania kategorii"];
                }
            );


    };

    $scope.createNewTeam= function(){


        console.log($scope.team);

        //$http.post('http://localhost:8096/team/createNewTeam', $scope.team);
        //$http.post($location.protocol()+'://'+$location.host()+':'+$location.port()+'/createNewTeam', $scope.team)

        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/createNewTeam/'
            + $scope.team.name + "/"
            + $scope.team.captainId + "/"
            + $scope.team.type
        )
            .then(function (result) {

                alert(result.data);
            },function(result){
                alert(result.data);

            });





    };





});