app.controller('ContactInfoController', ['$scope', '$routeParams', 'contact', function($scope, $routeParams, contact) {
    $scope.contact = contact.data;
}]);