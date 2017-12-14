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

            var params = {"departureCity":$scope.departureCity, "arrivalCity":$scope.arrivalCity, "status":$scope.status};

            params = clean(params);

            var qs = $httpParamSerializer(params);

            flightServices.allByFilter(qs ,function(response){
               $scope.flights = response.data.content;
            });

            function clean(obj) {
                for (var prop in obj) {
                    if (obj[prop] === null || obj[prop] === undefined || obj[prop] === "") {
                        delete obj[prop];
                    }
                }
                return obj;
            }
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
