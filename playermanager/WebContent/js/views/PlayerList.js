window.PlayerListView = Backbone.View.extend({

    initialize: function () {
        this.render();
    },

    render: function () {
        var players = this.model.models;
        
        var len = players.length;
        var startPos = (this.options.page - 1) * 25;
        var endPos = Math.min(startPos + 25, len);

        $(this.el).html('<div class="container"><table class="table"><thead><tr><th>Name</th><th>Here?</th><th>Contact</th><th>Allergies</th><th>Notes</th></tr></thead><tbody id="players"></tbody></table></div>');

        for (var i = startPos; i < endPos; i++) {
            $('#players', this.el).append(new PlayerListItemView({model: players[i]}).render().el);
        }

    	$(this.el).append(new Paginator({model: this.model, page: this.options.page}).render().el);

        return this;
    }
    
});

window.PlayerListItemView = Backbone.View.extend({

    tagName: "tr",

    initialize: function () {
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.close, this);
    },

    render: function () {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }

});