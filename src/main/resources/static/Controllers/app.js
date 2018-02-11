var app = angular.module('mainModule', ['ngRoute']);

app.config(function($routeProvider) {
    $routeProvider



        .when('/newUser', {
            templateUrl:"/templates/newUser.html",
            controller:'newUserController'
        })

        .when('/admin', {
            templateUrl:"/templates/admin.html",
            controller:'adminController'
        })

        .when('/race', {
            templateUrl:"/templates/race.html",
            controller:'raceController'
        })

        .when('/home', {
            templateUrl:"/templates/home.html",
            controller:'homeController'
        })

        .when('/newTeam', {
            templateUrl:"/templates/newTeam.html",
            controller:'newTeamController'
        })

        .when ('/myTeam',{
            templateUrl:"/templates/myTeam.html",
            controller:'myTeamController'
        })

        .when ('/applyToTeam',{
            templateUrl:"/templates/applyToTeam.html",
            controller:'applyToTeamController'
        })

        .when ('/captainTeam',{
            templateUrl:"/templates/captainTeam.html",
            controller:'captainTeamController'
        })

        .when ('/login',{
            templateUrl:"/templates/login.html",
            controllerL:'loginController'
        })

        .otherwise({
            redirectTo: '/home',
            controller: 'homeController'
        })

    // $locationProvider.html5Mode(true);
    // $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});


