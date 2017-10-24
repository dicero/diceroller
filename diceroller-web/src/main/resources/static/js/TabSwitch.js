
/*初始css应设置tab2的display为none,
选中的元素的class为active*/

"use strict";
function TabSwitch(){
    this.cfg = {
    	index: 0,
    	activeClass: 'active'
    };
}
TabSwitch.prototype = {
    init:function(tab1,tab2,options){
        var CFG = $.extend(this.cfg,options);
        tab1.eq(CFG.index).addClass(CFG.activeClass);
        tab2.eq(CFG.index).addClass(CFG.activeClass);

        tab1.each(function(index,elment){
            tab1.eq(index).click(function(){
            	tab1.eq(CFG.index).removeClass(CFG.activeClass);
                tab2.eq(CFG.index).removeClass(CFG.activeClass);
                CFG.index = index;
                
            	$(this).addClass(CFG.activeClass);
            	tab2.eq(index).addClass(CFG.activeClass);
            })
        })
    },
    initEvent:function(tab1,tab2,CFG){

    }
}
