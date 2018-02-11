app.controller('applyToTeamController',function($scope, $location, $http, myFactory){

$scope.$watch('$viewContenrLoaded',function(){

    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/getAllTeams')
        .then(function(result){

           $scope.teams=result.data;

        },function(result){
            console.log("Błąd pobrania drużyn w widoku zgłoś się do druzyny.")

        });
});



$scope.teamMembers="";
$scope.applicationDetails={
    userId:"",
    teamId:""

};
    $scope.applicationDetails.userId=myFactory.getUser();


$scope.applyToTeam=function(id){
console.log($scope.applicationDetails.userId);
    $scope.applicationDetails.teamId=id;

    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/applyToTeam/'
        +$scope.applicationDetails.userId+'/'
        +$scope.applicationDetails.teamId)
        .then(function(result){
           alert(result.data) ;
        },function(result){
            alert("Podczas wysyłania zgłoszenia wystąpił błąd!") ;

        });

    };


$scope.showTeam = function(id){
    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/getMembers/'
        +id)
        .then(function(result){
            $scope.teamMembers=result.data;

        },function(result){
            alert("Podczas wysyłania składu wystąpił błąd!") ;

        });
};




});