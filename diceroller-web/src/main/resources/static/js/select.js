var SelectMedia = new function() {
  //查询条件;
  var conds = {
    "mediaType": "2",
    "fansNum": "ALL",
    "price": "ALL",
    "industryType": "ALL"
  };

  //获取url中的参数
  var getUrlParam = function(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return decodeURI(r[2]); return null; //返回参数值
  };

  //获取get请求链接;
  var getMediasUrl = function(type, fansNum, price, industryType, page) {
    var baseUrl = "/goods/select?";
    var gUrl = "";
    var params = "mediaType=" + type;
    params += "&fansNum=" + fansNum;
    params += "&price=" + price;
    params += "&industryType=" + industryType;
    params += "&page=" + page;
    gUrl = baseUrl + params;

    return gUrl;
  };

  //根据条件搜索自媒体;
  this._getMedias = function(type, fansNum, price, industryType) {
    conds.mediaType = type ? type : getUrlParam("mediaType");
    conds.fansNum = fansNum ? fansNum : getUrlParam("fansNum");
    conds.price = price ? price : getUrlParam("price");
    conds.industryType = industryType ? industryType : getUrlParam("industryType");

    var gUrl = "";
    
    gUrl = getMediasUrl(conds.mediaType, conds.fansNum, conds.price, conds.industryType, 1);
//    if (conds.mediaType == null || conds.fansNum == null || conds.price == null) {
//    	gUrl = getMediasUrl(2, 0, 0, 0, 1);
//    } else {
//    	gUrl = getMediasUrl(conds.mediaType, conds.fansNum, conds.industryType, conds.price, 1);
//    }

    window.location = gUrl;
  };

  //为当前选中条件增添样式;
  this._setFilter = function() {
    var type = getUrlParam("mediaType"),
        fans = getUrlParam("fansNum"),
        industryType = getUrlParam("industryType"),
        price = getUrlParam("price");
    
    if(type) {
      $("#medias li").each(function () {
        $(this).removeClass("selected");
        if ($(this).attr("data-code") == type) {
          $(this).addClass("selected");
        }
      });
    }

    if(fans) {
      $("#fansNum li").each(function () {
        $(this).removeClass("selected");
        if ($(this).attr("data-code") == fans) {
          $(this).addClass("selected");
        }
      });
    }
   
    if(price) {
      $("#price li").each(function () {
        $(this).removeClass("selected");
        if ($(this).attr("data-code") == price) {
          $(this).addClass("selected");
        }
      });
    }
    
    if(industryType) {
        $("#industryType li").each(function () {
          $(this).removeClass("selected");
          if ($(this).attr("data-code") == industryType) {
            $(this).addClass("selected");
          }
        });
      }
  };
  
  //根据页码翻页;
  var getMediaByPageNum = function(page) {
    var type = getUrlParam("mediaType"),
        fans = getUrlParam("fansNum"),
        industryType = getUrlParam("industryType"),
        price = getUrlParam("price");
    var gUrl = getMediasUrl(type, fans, price, industryType, page);
    
    window.location = gUrl;
  };

  //分页;
  this._paginate = function() {
    var cur_page = getUrlParam("page");

    $("#pagination").pagination({
      prevText: "上一页",
      nextText: "下一页",
      items: g_total,
      itemsOnPage: 10,
      currentPage: cur_page,
      onPageClick: function(pageNumber, event) {
        getMediaByPageNum(pageNumber);
      }
    });
  };
}

$(function(){
  SelectMedia._setFilter();
  SelectMedia._paginate();
});