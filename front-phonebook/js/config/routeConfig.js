app.config(function($routeProvider) {
    $routeProvider.when("/contacts", {
        templateUrl: "view/contacts.html",
        controller: "phonebookCtrl",
        resolve: {
            contacts: function(contactService) {
                return contactService.getContacts();
            },
            operators: function(operatorService) {
                return operatorService.getOperators();
            }
        }
    });

    $routeProvider.when("/new-contact", {
        templateUrl: "view/new-contact.html",
        controller: "newContactCtrl",
        resolve: {
            operators: function(operatorService) {
                return operatorService.getOperators();
            }
        }
    });

    $routeProvider.when("/contact-info/:id", {
        templateUrl: "view/contact-info.html",
        controller: "contactInfoCtrl",
        resolve: {
            contact: function(contactService, $route) {
                return contactService.getContact($route.current.params.id);
            }
        }
    });

    $routeProvider.otherwise({redirectTo: "/contacts"})
});