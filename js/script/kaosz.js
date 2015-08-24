/*
 * Mivel az eredeti xml fájlok magyarul vannak, így a karakter objektumban is magyarul fogom használni a változókat, hogy konzekvensen menthessem el.
 */

var app = angular.module('kaoszApp', []);

app.controller('kaoszCtrl', ['$scope', '$http', function($scope, $http) {
    $scope.loading = true;
    $scope.karakter = {
      nev : "",
      leiras : "",
      faj : ""
    };
    readData($scope, $http)
}]);

function readData($scope, $http) {
  var calls = {counter : 3};
  readXML($scope, $http, 'data/xml/konstansok.xml', calls);
  readXML($scope, $http, 'data/xml/fajok.xml', calls);
  readXML($scope, $http, 'data/xml/jartassagok.xml', calls);
}

function readXML($scope, $http, fileName, calls) {
  $http.get(fileName).success(function (data){
    xml = data;
    var x2js = new X2JS();
    json = x2js.xml_str2json(xml);
    for(var child in json) {
      $scope[child]=json[child];
    }
    siteLoaded($scope, calls);
  });
}

function siteLoaded($scope, calls) {
  if (--calls.counter == 0) {
      $scope.loading = false;
  }
}