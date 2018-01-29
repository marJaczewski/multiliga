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

        .when('/home', {
            templateUrl:"/templates/home.html",
            controller:'homeController'
        })
        .otherwise({
            redirectTo: '/home',
            controller: 'homeController'
        })

    // $locationProvider.html5Mode(true);
    // $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
});
