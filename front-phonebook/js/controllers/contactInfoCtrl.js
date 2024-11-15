app.controller('contactInfoCtrl', ['$scope', '$routeParams', 'contact', function($scope, $routeParams, contact) {
    $scope.contact = contact.data;
}]);