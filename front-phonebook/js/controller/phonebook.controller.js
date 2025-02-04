app.controller('PhonebookController', ['$scope', 'ContactService', 'operators', function($scope, ContactService, operators) {
  $scope.contacts = [];
  $scope.operators = operators.data;

  const loadContacts = () => {
    ContactService.getContacts().then(function(response) {
      $scope.contacts = response.data;
    });
  };

  $scope.deleteContacts = () => {
    $scope.contacts.forEach(contact => {
      if (contact.selected) {
        const index = $scope.contacts.indexOf(contact);
        if (index !== -1) {
          $scope.contacts.splice(index, 1);
        }
        ContactService.deleteContact(contact.id);
      }
    });
  };

  $scope.order = (field) => {
    $scope.ordenation = field;
    $scope.direction = !$scope.direction;
  };
  
  $scope.selected = 'selected'

  loadContacts();
}]);