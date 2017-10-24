var Dynamics = new function(){
  //获取url中的参数
  var getUrlParam = function(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return decodeURI(r[2]); return null; //返回参数值
  };
  
  //根据页码翻页;
  var getDynamicsByPageNum = function(page) {
    var baseUrl = "http://localhost:8080/article/more/"+type+"?";
    var gUrl = baseUrl + "page=" + page;
    
    window.location = gUrl;
  };

  //分页;
  this._paginate = function() {
    var cur_page = getUrlParam("page");
    
    $("#pagination").pagination({
      prevText: "上一页",
      nextText: "下一页",
      items: count,
      itemsOnPage: 15,
      currentPage: cur_page,
      onPageClick: function(pageNumber, event) {
        getDynamicsByPageNum(pageNumber);
      }
    });
  };
};

!(function(){
  var minHeight = window.innerHeight - 315;
  
  $(".dynamics-box").css("minHeight", minHeight > 405 ? minHeight : 405);
  Dynamics._paginate();
})();