app.config(function($routeProvider) {
    $routeProvider.when('/contacts', {
        templateUrl: 'view/contacts.html',
        controller: 'PhonebookController',
        resolve: {
            contacts: function(ContactService) {
                return ContactService.getContacts();
            },
            operators: function(OperatorService) {
                return OperatorService.getOperators();
            }
        }
    });

    $routeProvider.when('/new-contact', {
        templateUrl: 'view/new-contact.html',
        controller: 'NewContactController',
        resolve: {
            operators: function(OperatorService) {
                return OperatorService.getOperators();
            }
        }
    });

    $routeProvider.when('/contact-info/:id', {
        templateUrl: 'view/contact-info.html',
        controller: 'ContactInfoController',
        resolve: {
            contact: function(ContactService, $route) {
                return ContactService.getContact($route.current.params.id);
            }
        }
    });

    $routeProvider.otherwise({redirectTo: '/contacts'})
});