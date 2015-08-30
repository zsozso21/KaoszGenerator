app.directive('spin', function() {
    return {
        templateUrl: 'spinner.html',
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
                stepinterval: step,
                initval: initial,
                forcestepdivisibility : 'none',
                booster : false
            });

            input.on('change', function(e){
              scope.value = input.val();
              
              //hack
              if(!scope.$$phase) {
                scope.$apply();
              }

            });

          }
        }
    };
}); 
