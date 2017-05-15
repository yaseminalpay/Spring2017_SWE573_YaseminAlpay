angular.module('app.services', []).factory('Shipwreck', function($resource) {
  return $resource('/api/v1/shipwrecks/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
}).factory('Query', function($resource) {
    return $resource('/api/v1/queries/:id', { id: '@id' }, {
        update: {
            method: 'PUT'
        }
    });
}).factory('SavedTweet', function($resource) {
    return $resource('/api/v1/search');
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
