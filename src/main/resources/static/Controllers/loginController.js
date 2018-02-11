app.controller('loginController', function($scope, $http, $location, myFactory) {
    document.getElementById("annonymusNav").style.visibility = "visible";
    document.getElementById("userNav").style.visibility = "hidden";
    document.getElementById("captainNav").style.visibility = "hidden";

    $scope.loggedDetails = {
        id: 0,
        role: "",
        email: ""

    };
    $scope.queryEmail = "";
    $scope.password = "";
$scope.zal="";
    $scope.doLogin = function () {


        $http.get($location.protocol() + '://' + $location.host() + ':' + $location.port() + '/logging/' + $scope.queryEmail + '/' + $scope.password)
            .success(function (result) {

                $scope.loggedDetails = result;

               if($scope.loggedDetails[0].role==="user"||$scope.loggedDetails[0].role==="captain"||$scope.loggedDetails[0].role==="admin"){
                   myFactory.setUser($scope.loggedDetails[0].id);
                   myFactory.setUserRole($scope.loggedDetails[0].role);
                   myFactory.setLogged(true);
                   myFactory.setUserEmail($scope.loggedDetails[0].email);

                   console.log(myFactory.getUser());
                   console.log(myFactory.getUserRole());
                   console.log(myFactory.getUserEmail());

                   if($scope.loggedDetails[0].role==="user"){
                       document.getElementById("annonymusNav").style.visibility = "hidden";
                       document.getElementById("userNav").style.visibility = "visible";
                       document.getElementById("captainNav").style.visibility = "hidden";
                   }else if ($scope.loggedDetails[0].role==="captain")  {
                       document.getElementById("annonymusNav").style.visibility = "hidden";
                       document.getElementById("userNav").style.visibility = "hidden";
                       document.getElementById("captainNav").style.visibility = "visible";
                   }




                   alert("Zalogowano!");

                   window.location.href = "#home";
               }
                else{
                   console.log("bladLogowania");

                   alert("Nie właściwe dane logowania!");
               }


            }).error(function (result) {
            console.log("bladLogowania");

            alert("Nie właściwe dane logowania!");

        })
    };


    $scope.unLogging = function(){

         document.getElementById("annonymusNav").style.visibility = "visible";
        document.getElementById("userNav").style.visibility = "hidden";
        document.getElementById("captainNav").style.visibility = "hidden";
        myFactory.setUser(0);
        myFactory.setLogged(false);
        myFactory.setUserRole("");
        myFactory.setUserEmail("");

        alert("Wylogowano");
        console.log(myFactory.getUser());
        console.log(myFactory.getUserRole());
        console.log(myFactory.getUserEmail());

        window.location.href = "#home";
    };




});



app.factory('myFactory', function () {
    var userId = 0;
    var logged = false;
    var userEmail;
    var userRole;

    var service = {};

    service.getUser = function () { return userId; };
    service.setUser = function (userIdService){ userId =  userIdService; };

    service.getLogged = function(){return logged};
    service.setLogged = function(loggedParam){logged=loggedParam};

    service.getUserRole = function (){return userRole};
    service.setUserRole = function (role) {userRole=role};

    service.getUserEmail = function (){return userEmail};
    service.setUserEmail = function (email){userEmail=email};
    return service;
});
