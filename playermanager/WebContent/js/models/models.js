 var secureSync = function(method, model, options) {
	 
    options.beforeSend = function(jqXHR) {
    	if (window.username != "" && window.password != ""
    		&& window.username != undefined && window.password != undefined) {
	    		
		    jqXHR.setRequestHeader(
		      'Authorization', 
		      'Basic ' + btoa(window.username + ':' + window.password)
		    );
    	}
	  };
	  
	  // Call the default Backbone sync implementation
	  Backbone.sync.call(this, method, model, options);  
	};    

window.SecureModel = Backbone.Model.extend({

    initialize: function() {
        this.validators = {};
        this.bind("error", this.defaultErrorHandler);
    },

    validateItem: function (key) {
        return (this.validators[key]) ? this.validators[key](this.get(key)) : {isValid: true};
    },

    // TODO: Implement Backbone's standard validate() method instead.
    validateAll: function () {

        var messages = {};

        for (var key in this.validators) {
            if(this.validators.hasOwnProperty(key)) {
                var check = this.validators[key](this.get(key));
                if (check.isValid === false) {
                    messages[key] = check.message;
                }
            }
        }

        return _.size(messages) > 0 ? {isValid: false, messages: messages} : {isValid: true};
    },
    
    defaultErrorHandler: function(model, error) {
        if (error.status == 401 || error.status == 403) {
            document.location.replace("#accessDenied");
        }
    },
    
    sync: secureSync
    
});

window.Player = SecureModel.extend({

    urlRoot: "players",

    defaults: {
        id: null,
        firstName: "",
        lastName: "",
        squadNumber: "",
        allergies: "",
        notes: "",
        email: "",
        mobile: ""
    }
});


window.SecureCollection = Backbone.Collection.extend({
    
    initialize: function() {
        this.bind("error", this.defaultErrorHandler);
    },
    
    defaultErrorHandler: function(model, error) {
        if (error.status == 401 || error.status == 403) {
            document.location.replace("#accessDenied");
        }
    },

    sync: secureSync
});

window.PlayerCollection = SecureCollection.extend({

    model: Player,

    url: "players",

    parse: function(resp, xhr) {
        return resp.player;
      }
      
});

