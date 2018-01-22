function ImgPreview(){}
  
ImgPreview.prototype.preview=function(options){
   
 var time = new Date().getTime();
 var fileid = "file" + time;
 var xdelid = "xdel" + time;
 var delid = "del" + time; 
 var viewid = "view" + time;
   
 var htm = "" +
 "<div id='" + viewid + "'></div>" +
     "<div>" +
     "<div class='dft'>" +
     "<a class='btn-pic btn-pic-bg' href='javascript:void(0);' type='submit'>" +
     "<span>上传头像</span>" +
     "<input id='" + fileid + "' type='file' name='myFile' class='ipt-bg' style='margin-bottom: 10px'/>" +
     "</a>" +
     "</div>" +
     "</div>";
   
 $("#" + options.previewid).html(htm);
   
 $("#" + fileid).bind("click",function(){
    
  var $this =$(this);
    
  var browser={
   isIE:function(ver){
    var b = document.createElement('b');
    b.innerHTML = '<!--[if IE ' + ver + ']><i></i><![endif]-->';
    return b.getElementsByTagName('i').length === 1;
   }
  };
    
  $this.change(function(){
   var regex=/(.*)\.(jpg|jpeg|png)$/;
   var val = $this.val();
   if(!regex.test(val)){
    $("#" + viewid).html("<span class='spanc'>请选择正确的图片（jpg、jpeg、png）!</span>");
    return;
   }
     
   if(browser.isIE(6)){
    HanderOther($this);
   }else if(browser.isIE(7) || browser.isIE(8) || browser.isIE(9)){
    HanderIE789($this);
   }else if(window.FileReader){
    HanderFileReader($this);
   }else{
    $("#" + viewid).html("<span class='spanc'>该浏览器不支持预览图片!</span>");
   }
     
   function HanderFileReader($this){
    var oFReader = new window.FileReader(),
    rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;
    oFReader.onload = function (oFREvent){
     $("#" + viewid).html("<img src='"+oFREvent.target.result+"' style='width:200px;height:200px;'/>");
     $("#" + xdelid).show();
    };
   
    var aFiles = $this.get(0).files;
    if (aFiles.length == 0) { return; }
    if (!rFilter.test(aFiles[0].type)) { 
     $("#" + viewid).html("<span class='spanc'>请选择正确的图片（jpg、jpeg、png）!</span>"); 
     return; 
    }
    oFReader.readAsDataURL(aFiles[0]);
   }
   
   function HanderIE789($this){
    if(options.width != null && parseInt(options.width) > 0){
     $("#" + viewid).css("width",options.width + "px");
    }else{
     $("#" + viewid).css("width","378px");
    }
    if(options.height != null && parseInt(options.height) > 0){
     $("#" + viewid).css("height",options.height + "px");
    }else{
     $("#" + viewid).css("height","358px");
    }
    $("#" + viewid).css("filter","progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src='"+GetImgSrc($this)+"')");
    $("#" + xdelid).show();
   }
   
   function HanderOther($this){
    $("#" + viewid).html("<img src='"+$this.val()+"' style='width:100%;height:100%;margin-right:50px;'/>");
    $("#" + xdelid).show();
   }
   
   function GetImgSrc($this){
    $this.select();
    $this.blur();
    var imgSrc =document.selection.createRange().text;
    document.selection.empty();
    return imgSrc;
   }
     
     
  });
 });//绑定按钮事件
   
 $("#" + delid).bind("click",function(){
  var browser={
    isIE:function(ver){
     var b = document.createElement('b');
     b.innerHTML = '<!--[if IE ' + ver + ']><i></i><![endif]-->';
     return b.getElementsByTagName('i').length === 1;
    }
   };
    
  if(browser.isIE(7) || browser.isIE(8) || browser.isIE(9)){
   $("#" + fileid).val('');
   $("#" + viewid).css("filter","");
   $("#" + viewid).css("width","");
   $("#" + viewid).css("height","");
   $("#" + xdelid).hide();
  }else{
   $("#" + fileid).val('');
   $("#" + viewid).empty();
   $("#" + xdelid).hide();
  }
 });
};