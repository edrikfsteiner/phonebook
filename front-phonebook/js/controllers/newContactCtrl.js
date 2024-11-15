app.controller('newContactCtrl', ['$scope', '$location', 'contactService', 'operators', function($scope, $location, contactService, operators) {
    $scope.operators = operators.data;

    $scope.addContact = (contact) => {
        contactService.postContact(contact).then(function() {
            delete $scope.contact;
            $scope.contactForm.$setPristine();
            $location.path("/contacts")
        });
    };
}]);