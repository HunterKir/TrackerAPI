angular.module('appModule').factory('trackerService', function($http){
	var service = {};
	// USER ID IS HARDCODED EVERYWHERE
	service.index = function(uid) {
		return $http({
			method : 'GET',
			url : 'api/users/' + '1' + '/presets'
		});
	};

	service.showPreset = function(uid, pid) {
		return $http({
			method : 'GET',
			url : 'api/users/' + '1' + '/presets/' + pid
		});
	};

	service.showButton = function(uid, pid, bid) {
		return $http({
			method : 'GET',
			url : 'api/users/' + '1' + '/presets/' + pid + '/buttons/' + bid,
		});
	};

	service.deletePreset = function(uid, pid) {
		return $http({
			method : 'DELETE',
			url : 'api/users/' + '1' + '/presets/' + pid
		});
	};

	service.deleteButton = function(uid, pid, bid) {
		return $http({
			method : 'DELETE',
			url : 'api/users/' + '1' + '/presets/' + pid + '/buttons/' + bid
		});
	};

	service.createUser = function(user) {
		return $http({
			method : 'POST',
			url : 'api/users',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : user
		});
	};

	service.createPreset = function(uid, preset) {
		return $http({
			method : 'POST',
			url : 'api/users/' + '1' + '/presets',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : preset
		});
	};

	service.createButton = function(uid, pid, button) {
		return $http({
			method : 'POST',
			url : 'api/users/' + '1' + '/presets/' + pid + '/buttons',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : button
		});
	};

	service.updateUser = function(uid, user) {
		return $http({
			method : 'PUT',
			url : 'api/users/' + '1',
			headers : {
				'Content-Type' : 'application/json'
			},
			data : user
		});
	};

	service.updatePreset = function(uid, pid, preset) {
		return $http({
			method : 'PUT',
			url : 'api/users/' + '1' + '/presets/' + pid,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : preset
		});
	};

	service.updateButton = function(uid, pid, bid, button) {
		return $http({
			method : 'PUT',
			url : 'api/users/' + '1' + '/presets/' + pid + '/buttons/' + bid,
			headers : {
				'Content-Type' : 'application/json'
			},
			data : button
		});
	};
	return service;
});
