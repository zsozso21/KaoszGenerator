/*
 * Mivel az eredeti xml fájlok magyarul vannak, így a karakter objektumban is magyarul fogom használni a változókat, hogy konzekvensen menthessem el.
 */

var app = angular.module('kaoszApp', []);

app.controller('kaoszCtrl', ['$scope', '$http', function($scope, $http) {
  $scope.loading = true;
  
  $scope.karakter = {
    nev : "",
    leiras : "",
    foertekek : {},
    pontosztas: "szabalyos",
    egyenipontosztas: {
      foertekpontok : 220,
      jartassagpontok: 10000,
      maxjartassagszint: 3
    },
    korosztaly: {
      nev: "adultus",
      juvenis: {
	foertekpontok: 80,
	jartassagpontok: 80
      },
      senius: {
	foertekpontok: 80,
	jartassagpontok: 200,
	maxjartassagszint: 3
      }
    }
  };
  
  $scope.consts = {
    standard : "szabalyos",
    custom : "egyeni",
    juvenis : "juvenis",
    adultus : "adultus",
    senius : "senius",
  };
  
  $scope.eloszthatoJartassagPontok = function() {
    if ($scope.karakter.pontosztas == $scope.consts.custom){
      return $scope.karakter.egyenipontosztas.jartassagpontok;
    }
    
    if ($scope.konstansok === undefined) {
      return 0;
    }
    var orig = $scope.konstansok.jartassagpontok._ertek;
    
    if ($scope.karakter.korosztaly.nev == $scope.consts.juvenis) {
      return Math.round($scope.karakter.korosztaly.juvenis.jartassagpontok * orig / 100);
    }
    
    if ($scope.karakter.korosztaly.nev == $scope.consts.senius) {
      return Math.round($scope.karakter.korosztaly.senius.jartassagpontok * orig / 100);
    }
    
    return orig;
  };
  
  $scope.eloszthatoFoertekPontok = function() {
    if ($scope.karakter.pontosztas == $scope.consts.custom){
      return $scope.karakter.egyenipontosztas.foertekpontok;
    }
    
    if ($scope.konstansok === undefined) {
      return 0;
    }
    var orig = $scope.konstansok.foertekpontok._ertek;
    
    if ($scope.karakter.korosztaly.nev == $scope.consts.juvenis) {
      return Math.round($scope.karakter.korosztaly.juvenis.foertekpontok * orig / 100);
    }
    
    if ($scope.karakter.korosztaly.nev == $scope.consts.senius) {
      return Math.round($scope.karakter.korosztaly.senius.foertekpontok * orig / 100);
    }
    
    return orig;
  };
  
  $scope.maxjartassagszint = function() {
    if ($scope.karakter.pontosztas == $scope.consts.custom){
      return $scope.karakter.egyenipontosztas.maxjartassagszint;
    }
    
    if ($scope.karakter.korosztaly.nev == $scope.consts.senius) {
      return $scope.karakter.korosztaly.senius.maxjartassagszint;
    }
    
    if ($scope.fajok === undefined) {
      return 0;
    }
    
    return $scope.karakter.faj.maximalisJartassagszint;
    
  };
  
  readData($scope, $http);
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
  /*$scope.karakter.faj = "Ember";
  $scope.karakter.eloszthatoFoertek: $scope.konstansok.foertekpontok._ertek;
  $scope.karakter.eloszthatoJartassagpontok: $scope.konstansok.foertekpontok._ertek;*/
}