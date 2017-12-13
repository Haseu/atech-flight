/**
 * Created by André Menutole on 12/12/2017.
 */
'use strict';

var app = angular.module('app', [
    'ngRoute',
    'appControllers',
    'appServices'
]);

app.config(['$routeProvider',
    function($routeProvider) {

        $routeProvider.
        when('/', {
            templateUrl: 'views/flights.html',
            controller: 'FlightCtrl'
        }).
        when('/flight', {
            templateUrl: 'views/flights.html',
            controller: 'FlightCtrl'
        }).
        when('/flight/:id', {
            templateUrl: 'views/flight-detail.html',
            controller: 'FlightDetailCtrl'
        }).
        otherwise({
            redirectTo: '/'
        });

    }]
);
