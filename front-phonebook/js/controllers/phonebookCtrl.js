app.controller('phonebookCtrl', ['$scope', 'contactService', 'operators', function($scope, contactService, operators) {
  $scope.contacts = [];
  $scope.operators = operators.data;

  const loadContacts = () => {
    contactService.getContacts().then(function(response) {
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
        contactService.deleteContact(contact.id);
      }
    });
  };

  $scope.order = (field) => {
    $scope.ordenation = field;
    $scope.direction = !$scope.direction;
  };
  
  $scope.selected = "selected"

  loadContacts();
}]);