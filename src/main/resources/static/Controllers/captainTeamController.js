app.controller('captainTeamController', function($scope, $location, $http, myFactory){

    $scope.userId=myFactory.getUser();

    $scope.$watch('$viewContentLoaded', function() {
  $scope.showTeam($scope.userId);
  $scope.showApplications($scope.userId);
    });


    $scope.showTeam = function(id){
        $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/getMembers/'
            +id)
            .then(function(result){
                $scope.teamMembers=result.data;

            },function(result){
                alert("Podczas wysyłania składu wystąpił błąd!") ;

            });
    };

    $scope.teamApplications="";

$scope.showApplications = function (userId) {

    $scope.userId=userId;
    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/showApplications/'
        +userId)
        .then(function(result){
            $scope.teamApplications=result.data;

        },function(result){
            alert("Podczas wysyłania składu wystąpił błąd!") ;

        });


};

$scope.acceptApplication = function(applicationId){

    $http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/acceptApplication/'
        +applicationId)
        .then(function(result){
           alert(result.data);
           $scope.showApplications($scope.userId);
        },function(result){
            alert("Podczas procesu akceptacji wystąpił błąd!") ;

        });


};

$scope.setIdMemberToDelete = function (memberId){
    $scope.memberToDelete= memberId;

};


$scope.deleteMember = function(memberId){

$http.get($location.protocol()+'://'+$location.host()+':'+$location.port()+'/team/deleteMember/'+$scope.memberToDelete)
    .then(function(result){
        alert(result.data);
    },function(result){
        alert("Podczas procesu usuwania zawodnika z drużyny wystąpił problem!") ;
    });
};

$scope.allUsersWithoutTeam="";
$scope.getAllUsersWithoutTeam = function(){
    $http.get($location.protocol()+'://'+$location.host()+":"+$location.port()+'/team/getAllUsersWithoutTeam')
        .then(function(result){
            $scope.allUsersWithoutTeam=result.data;
        },function(result){

// alert("Wystąpił błąd podczas pobierania zawodników.")
            $scope.allUsersWithoutTeam=result.data;
        });

};
$scope.invitationAnswer="";

$scope.sendInvitation = function(userToInvite){
                                                                                            //kogo i kapitan jakiej drużyny
    $http.get($location.protocol()+'://'+$location.host()+":"+$location.port()+'/team/sendInvitation/'+ userToInvite+'/'+$scope.userId)
        .then(function(result){
            $scope.invitationAnswer=result.data;
        },function(result){

// alert("Wystąpił błąd podczas pobierania zawodników.")
            $scope.invitationAnswer=result.data;
        });

};




});