/**
 * Created by André Menutole on 12/12/2017.
 */
'use strict';

var appServices = angular.module('appServices', []);

appServices.factory('flightServices', ['$http',
    function($http) {
        return {
            get: function(id, success, error) {
                $http.get('/api/flights/' + id).then(success).catch(error)
            },
            all: function(success, error) {
                $http.get('/api/flights').then(success).catch(error)
            },
            allByFilter: function(params, success, error) {
                $http.get('/api/flights?' + params).then(success).catch(error)
            }
        };
    }]
);
