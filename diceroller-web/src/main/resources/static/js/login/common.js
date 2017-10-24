var Ajax = function() {
  var doPost = function(pUrl, pData) {
    return $.ajax({
      type: "post",
      url: pUrl,
      dataType: "json",
      data: pData
    });
  };

  this._post = function(pUrl, pData) {
    return doPost(pUrl, pData);
  };
};

/**
 * 表单处理成Json对象
 * @param data
 * @returns {returnData -- json对象}
 */
function turnToJsonData (data) {
  var returnData = {};
  
  $.each(data, function(i, field){
    if (returnData[field.name]) {
      if (!returnData[field.name].push) {
        returnData[field.name] = [returnData[field.name]];  
      }
      returnData[field.name].push(field.value || '');  
      } else {
        returnData[field.name] = field.value || '';  
      }  
  });
  
  return returnData;
}