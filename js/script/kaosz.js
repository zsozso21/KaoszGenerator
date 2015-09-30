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
    
    if ($scope.karakter.faj === undefined) {
      return 0;
    }
    
    return $scope.karakter.faj.maximalisJartassagszint;
    
  };
  
  readData($scope, $http);
}]);

app.directive('spin', function() {
    return {
        templateUrl: 'script/spinner.html',
        scope: {
          'value' : "="
        },
        restrict: 'E',
        link: function(scope, element, attrs, ngModel) {
          var min,max,step,value,input,initial;

          element = angular.element(element);

          if(typeof attrs === 'undefined'){
            throw new Error('Spin.js attributes missing');
          } else {
            min = typeof attrs.min !== 'undefined' ? attrs.min : 0;
            max = typeof attrs.max !== 'undefined' ? attrs.max : 999;
            step = typeof attrs.step !== 'undefined' ? attrs.step : 1;
            
            initial = parseInt(scope.value);

            input = $("input[name='spin']",element);
            input.TouchSpin({
                min: min,
                max: max,
                step: step,
                initval: initial,
                forcestepdivisibility : 'none',
                booster : false
            });
	    
	    attrs.$observe('min', function(value) { 
	      input.TouchSpin({
                min: value,
	      });
	      //alert(input);
	      //alert('d1-obsrv a6:' + value);
	    });
// 	    attrs.$observe('min', ...){
// 	      alert("dfadf");
// 	    }

            input.on('change', function(e){
              scope.value = input.val();
              //hack
              if(!scope.$$phase) {
                scope.$apply();
              }

            });

          }
        }/*,
        compile: function(tElement, tAttrs) {
	  return function link(scope, iElement, iAttrs) {
	    iAttrs.$observe('min', function(value) { alert('d1-obsrv a6:' + value); });
// 	    console.log('d1-link:', iAttrs.attr1, iAttrs.attr2, iAttrs.attr3, iAttrs.attr4, iAttrs.attr5, tAttrs.attr6);
// 	    scope.$watch(iAttrs.attr1, function(value) { console.log('d1-watch a1:', value); });
// 	    scope.$watch(iAttrs.attr2, function(value) { console.log('d1-watch a2:', value); });
// 	    scope.$watch(iAttrs.attr3, function(value) { console.log('d1-watch a3:', value); });
// 	    scope.$watch(iAttrs.attr4, function(value) { console.log('d1-watch a4:', value); });
// 	    scope.$watch(iAttrs.attr5, function(value) { console.log('d1-watch a5:', value); });
// 	    scope.$watch(iAttrs.attr6, function(value) { console.log('d1-watch a6:', value); });
// 	    iAttrs.$observe('attr1', function(value) { console.log('d1-obsrv a1:', value); });
// 	    iAttrs.$observe('attr2', function(value) { console.log('d1-obsrv a2:', value); });
// 	    iAttrs.$observe('attr3', function(value) { console.log('d1-obsrv a3:', value); });
// 	    iAttrs.$observe('attr4', function(value) { console.log('d1-obsrv a4:', value); });
// 	    iAttrs.$observe('attr5', function(value) { console.log('d1-obsrv a5:', value); });
// 	    iAttrs.$observe('attr6', function(value) { console.log('d1-obsrv a6:', value); });
	  };
	}*/
    };
}); 

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