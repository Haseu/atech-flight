/**
 * Created by André Menutole on 12/12/2017.
 */

'use strict';

var appControllers = angular.module('appControllers', []);



appControllers.controller('FlightCtrl', ['$scope', '$routeParams', 'flightServices', '$httpParamSerializer',
    function($scope, $routeParams, flightServices, $httpParamSerializer) {

        // Get all flights
        flightServices.all(function(response) {
            $scope.flights = response.data.content;
        });

        $scope.applyFilter = function() {

            var params = {"departureCity":$scope.departureCity, "arrivalCity":$scope.arrivalCity};
            var qs = $httpParamSerializer(params);

            flightServices.allByFilter(qs ,function(response){
               $scope.flights = response.data.content;
            });
        };
    }]
);

appControllers.controller('FlightDetailCtrl', ['$scope', '$routeParams', 'flightServices',
    function($scope, $routeParams, flightServices) {
        // Get flight by id
        flightServices.get($routeParams.id, function(response) {
            $scope.flight = response.data;
        });
    }]
);
