function toggleButtonClicked(toggleButton) {
	
	    if ($(toggleButton).attr('class-toggle') != undefined && !$(toggleButton).hasClass('disabled')) {
	        var btnGroup = $(toggleButton).parent('.btn-group');
	
	        if (btnGroup.attr('data-toggle') == 'buttons-radio') {
	            btnGroup.find('button').each(function() {
	                $(this).removeClass($(this).attr('class-toggle'));
	            });
	            $(toggleButton).addClass($(toggleButton).attr('class-toggle'));
	        }
	
	        if (btnGroup.attr('data-toggle') == 'buttons-checkbox' || $(toggleButton).attr('data-toggle') == 'button') {
	            if ($(toggleButton).hasClass('active')) {
	                $(toggleButton).removeClass($(toggleButton).attr('class-toggle'));
	            } else {
	                $(toggleButton).addClass($(toggleButton).attr('class-toggle'));
	            }
	        }

	    }
	};

