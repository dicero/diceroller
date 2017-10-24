 $(document).ready(function(){
	$(".main_visual").hover(function(){
		$("#btn_prev,#btn_next").fadeIn()
	},function(){
		$("#btn_prev,#btn_next").fadeOut()
	});
	
	$dragBln = false;
	
	$(".main_image").touchSlider({
		flexible : true,
		speed : 200,
		btn_prev : $("#btn_prev"),
		btn_next : $("#btn_next"),
		paging : $(".flicking_con a"),
		counter : function (e){
			$(".flicking_con a").removeClass("on").eq(e.current-1).addClass("on");
		}
	});
	
	$(".main_image").bind("mousedown", function() {
		$dragBln = false;
	});
	
	$(".main_image").bind("dragstart", function() {
		$dragBln = true;
	});
	
	$(".main_image a").click(function(){
		if($dragBln) {
			return false;
		}
	});
	
	timer = setInterval(function(){
		$("#btn_next").click();
	}, 5000);
	
	$(".main_visual").hover(function(){
		clearInterval(timer);
	},function(){
		timer = setInterval(function(){
			$("#btn_next").click();
		},5000);
	});
	
	$(".main_image").bind("touchstart",function(){
		clearInterval(timer);
	}).bind("touchend", function(){
		timer = setInterval(function(){
			$("#btn_next").click();
		}, 5000);
	});
	
    //图片滚动
	function scrollMarq(id){
	    var speed=40; //数字越大速度越慢
	    var tab=document.getElementById(id);
	    var tab1=$(tab).find(".scroll1")[0];
	    var tab2=$(tab).find(".scroll2")[0];
	    tab2.innerHTML=tab1.innerHTML;
	    function Marquee(){
	        if(tab2.offsetWidth-tab.scrollLeft<=0)
	            tab.scrollLeft-=tab1.offsetWidth
	        else{
	            tab.scrollLeft++;
	        }
	    }
	    var MyMar=setInterval(Marquee,speed);
	    tab.onmouseover=function() {clearInterval(MyMar)};
	    tab.onmouseout=function() {MyMar=setInterval(Marquee,speed)};
	}
	
	scrollMarq("scrollWrap");
	
	$(".jobTab1").eq(0).addClass("active");
	$(".starList").eq(0).show();
	
	$(".mediaType_title").on("click","li",function(){
		var _this = $(this),
		index = $(".mediaType_title li").index(_this);
		
		$(".mediaType_title li").removeClass("active");
		_this.addClass("active");
        $(".starList").hide().eq(index).show();
	})
	
    //	招聘岗位切换
	new TabSwitch().init($(".recruitment_item li"),$(".jobDetails"));
});