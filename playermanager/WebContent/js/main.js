var AppRouter = Backbone.Router.extend({

    routes: {
        ""                      				: "login",
        "accessDenied"          				: "accessDenied",
        "home"                  				: "training",
        "training"								: "training",
        "jordanhillfc/p4s/players"				: "list",
        "jordanhillfc/p4s/players/page/:page"	: "list",
        "jordanhillfc/p4s/players/add"         	: "add",
        "jordanhillfc/p4s/players/:id"         	: "details",
        "about"             					: "about"
    },

    initialize: function () {
    	this.headerView = new HeaderView();
    	$('.header').html(this.headerView.el);
    },

    accessDenied: function () {
    	document.getElementById("subheading").innerHTML = "Sign in";
        this.loginView = new LoginView();
        $("#content").html();
        utils.showAlert("Oh NO!", "That didn't work... try again", "alert-error");        
    },
    
    login: function () {
    	document.getElementById("subheading").innerHTML = "Sign in";
        this.loginView = new LoginView();
        $("#content").html(this.loginView.el);
    },

    home: function () {
    },

	training: function(page) {
    	document.getElementById("subheading").innerHTML = "Training";
        if (!this.trainingView) {
            this.trainingView = new TrainingView();
        }
        $('#content').html(this.trainingView.el);
        this.headerView.selectMenuItem('training-menu');
    },

	list: function(page) {
    	document.getElementById("subheading").innerHTML = "Training <small>on 29th September 2012</small>";
        var p = page ? parseInt(page, 10) : 1;
        var playerList = new PlayerCollection();
        playerList.fetch({success: function(){
            $("#content").html(new PlayerListView({model: playerList, page: p}).el);
        }});
        this.headerView.selectMenuItem('home-menu');
    },

    details: function (id) {
    	document.getElementById("subheading").innerHTML = "Player Details";
        var player = new Player({id: id});
        player.fetch({success: function(){
            $("#content").html(new PlayerView({model: player}).el);
        }});
        this.headerView.selectMenuItem();
    },

	add: function() {
    	document.getElementById("subheading").innerHTML = "Add Player";
        var player = new Player();
        $('#content').html(new PlayerView({model: player}).el);
        this.headerView.selectMenuItem('add-menu');
	},

    about: function () {
    	document.getElementById("subheading").innerHTML = "About";
        if (!this.aboutView) {
            this.aboutView = new AboutView();
        }
        $('#content').html(this.aboutView.el);
        this.headerView.selectMenuItem('about-menu');
    }

});

utils.loadTemplate(['LoginView', 'HeaderView', 'TrainingView', 'PlayerView', 'PlayerListItemView', 'AboutView'], function() {
    app = new AppRouter();
    Backbone.history.start({
    	  root: '/playermanager/',
    	  pushState: true,
    	  silent: false
    	});
    
    $(document).on('click', 'a:not([data-bypass])', function (evt) {

        var href = $(this).attr('href');
        var protocol = this.protocol + '//';

        if (href.slice(protocol.length) !== protocol) {
          evt.preventDefault();
          app.navigate(href, true);
        }
      });        
});