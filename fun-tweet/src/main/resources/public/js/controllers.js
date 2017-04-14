angular.module('app.controllers', []).controller('QueryListController', function($scope, $state, popupService, $window, Query) {
  $scope.queries = Query.query(); //fetch all saved queries. Issues a GET to /api/v1/queries

}).controller('QueryCreateController', function($scope, $state, $stateParams, Query) {
    $scope.query = new Query();  //create new shipwreck instance. Properties will be set via ng-model on UI

    $scope.addQuery = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
        $scope.query.$save(function() {
            $state.go('queries'); // on success go back to the list i.e. shipwrecks state.
        });
    };
}).controller('QueryViewController', function($scope, $stateParams, Query) {
    $scope.query = Query.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('TweetListController', function($scope, $state, popupService, $window, Tweet) {
    $scope.tweets = Tweet.query(); //fetch all saved queries. Issues a GET to /api/v1/tweets;
});
