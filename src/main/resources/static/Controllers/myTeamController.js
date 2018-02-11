app.controller('myTeamController', function($scope, $location, $http, myFactory){

//pobranie info odnośnie drużyny zawodnika
// $scope.userId="";
    $scope.userId=myFactory.getUser();
    $scope.myTeam="";

    $scope.$watch('$viewContentLoaded', function() {
        $scope.getMyTeam();
        $scope.getMyInvitations();
    });




$scope.getMyTeam=function(){

        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/getMyTeam/'+$scope.userId)
            .then(function(result){


                $scope.myTeam=result.data

            },function(result){

            })

    };

$scope.getOutFromTeam = function(){
    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/deleteMember/'+$scope.userId)
        .then(function(result){

alert(result.data);
            document.getElementById("lostTeamButton").style.visibility="hidden";
            $scope.getMyTeam();
        },function(result){
alert("Błąd podczas usuwania z drużyny");
        })

};

$scope.getMyInvitations = function(){

    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/getMyInvitations/'+$scope.userId)
        .then(function(result){

           $scope.teams=result.data;
        },function(result){
            alert("Błąd podczas usuwania z drużyny");
        })


};

$scope.acceptInvitation = function(teamId){
    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/acceptInvitation/'+$scope.userId+'/'+teamId)
        .then(function(result){
            $scope.getMyInvitations();
            $scope.getMyTeam();
            alert(result.data);

        },function(result){
            alert("Błąd podczas akceptowania zawodnika");
        })


};

});
