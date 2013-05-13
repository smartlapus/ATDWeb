$(document).ready(function () {
	load_tooltip();
	dropDown();
	setInterval('slideShow()', 5000);
})

/* INPUT VALUE */
function onBlur(el) {
    if (el.value == '') { el.value = el.defaultValue; }
}

function onFocus(el) {
    if (el.value == el.defaultValue) { el.value = ''; }
}

/* TOOLTIP */
function load_tooltip() {
	$('.load_tooltip').unbind('hover');
	$('.load_tooltip').hover(function (e) {
		var pos = $(this).offset();
		var $title = $(this).attr('data-title');
		var len = $title.length;
		if(len>155)	{
			$title = $title.substr(0, 155)+'...';
		}
		$('<div class="tooltip"></div>')
		.text($title)
		.appendTo('body')
		.css({
			top : pos.top + $(this).height() + 10,
			left : pos.left + $(this).width() / 2 - $('.tooltip').width() / 2 - 10
		}).fadeIn('normal');
	}, function (e) {
		$('.tooltip').remove();
	});
}

/* SLIDESHOW */
function slideShow() {
	var $active = $('#image-slider-container .active');
	var $next = ($active.next().length > 0) ? $active.next() : $('#image-slider-container img:first');
	$next.css('z-index',2);
	$active.fadeOut(1500,function() {
		$active.css('z-index',1).show().removeClass('active');
		$next.css('z-index',3).addClass('active');
	});
}

/* DROPDOWN */
function dropDown() {
	$('#nav li').hover(
		function () {
			$(this).css("background", "#333");
			$('a.button', this).css("color", "#FF8000");
			$('ul', this).stop().slideDown(100);
	}, 
		function () {
			$(this).css("background", "none");
			$('a.button', this).css("color", "#FFF");
			$('ul', this).stop().slideUp(100);			
		}
	);
}