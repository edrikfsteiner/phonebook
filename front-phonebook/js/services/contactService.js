app.service('contactService', ['$http', function($http) {
    const apiUrl = 'http://localhost:8080/contacts';
    
    return {
        getContact: function(id) {
            return $http.get(`${apiUrl}/${id}`)
        },

        getContacts: function() {
            return $http.get(`${apiUrl}`);
        },
        
        postContact: function(contact) {
            return $http.post(`${apiUrl}`, contact);
        },

        putContact: function(contact) {
            return $http.put(`${apiUrl}`, contact);
        },
        
        deleteContact: function(id) {
            return $http.delete(`${apiUrl}/${id}`);
        }
    };
}]);