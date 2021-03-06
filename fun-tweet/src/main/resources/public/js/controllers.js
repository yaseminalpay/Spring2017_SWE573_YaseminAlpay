angular.module('app.controllers', [])
.controller('QueryListController',
		function($scope, $state, popupService, $window, Query) {
			$scope.queries = Query.query(); // fetch all saved queries. Issues a
											// GET to /api/v1/queries
			$scope.deleteQuery = function(query) {
				if (popupService.showPopup('Really delete this?')) {
					query.$delete(function() {
						$scope.queries = Query.query();
						$state.go('queries');
					});
				}
			};
		})
.controller('QueryCreateController',
		function($scope, $state, $stateParams, Query) {
			$scope.query = new Query();

			$scope.addQuery = function() {
				$scope.query.$save(function() {
					$state.go('queries');
				});
			};
		})
.controller('QueryViewController',
		function($scope, $stateParams, Query) {
			$scope.query = Query.get({
				id : $stateParams.id
			});
		})
.controller('QueryEditController',
		function($scope, $stateParams, Query) {
			$scope.query = Query.update({
				id : $stateParams.id
			});
		})
.controller('QueryDeleteController',
		function($scope, $stateParams, Query) {
			$scope.query = Query.splice({
				id : $stateParams.id
			});
		})
.controller('TweetSearchController',
		function($scope, $stateParams, SearchedTweet) {
		$scope.savedTweets = SearchedTweet.query({
			queryString : $stateParams.queryString
	});
});
