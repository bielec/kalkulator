(function(angular) {
	var AppController = function($scope, $http, Item) {

		$http.get('/service/countries').then(function(resp) {
			console.log('Success', resp);
			$scope.countries = resp.data;
		}, function(err) {
			console.error('ERR', err);
		})

		$scope.calculateSalary = function() {
			var dataObj = {
				'country' : $scope.salaryServiceInput.country.name,
				'dailyRate' : $scope.salaryServiceInput.dailyRate
			};
			
			$http.post('/service/calculate', dataObj).then(function(resp) {
				console.log('Success', resp.data);
				$scope.salaryServiceOutput = resp.data;
			}, function(err) {
				console.error('ERR', err);
			});
		};

		$scope.$watch("salaryServiceInput.dailyRate", function(newValue,
				oldValue) {
			if ($scope.salaryServiceInput.dailyRate == null) {
				$scope.salaryServiceOutput.salary = 0;
			}
			if ($scope.salaryServiceInput.dailyRate > 0) {
				$scope.calculateSalary();
			}
		});
		
		$scope.$watch("salaryServiceInput.country", function(newValue,
				oldValue) {
			if ($scope.salaryServiceInput.dailyRate > 0) {
				$scope.calculateSalary();
			}
		});

		$scope.salaryServiceInput = {
			country : {},
			dailyRate : ''
		};
		$scope.salaryServiceOutput = {
			salary : 0,
			paidTax : 0,
			taxRate : 0,
			costOfIncome : 0
		};
	};

	AppController.$inject = [ '$scope', '$http' ];
	angular.module("myApp.controllers").controller("AppController",
			AppController);
}(angular));