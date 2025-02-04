app.controller('NewContactController', ['$scope', '$location', 'ContactService', 'operators', function($scope, $location, ContactService, operators) {
    $scope.operators = operators.data;

    $scope.addContact = (contact) => {
        ContactService.postContact(contact).then(function() {
            delete $scope.contact;
            $scope.contactForm.$setPristine();
            $location.path('/contacts')
        });
    };
}]);