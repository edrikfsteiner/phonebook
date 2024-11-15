app.service('operatorService', ['$http', function($http) {
  const apiUrl = 'http://localhost:8080/operators';

  this.getOperators = () => {
    return $http.get(`${apiUrl}`);
  };
}]);