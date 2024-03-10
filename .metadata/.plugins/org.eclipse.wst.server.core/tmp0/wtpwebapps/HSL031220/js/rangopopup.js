/***************************/
//@Author: Adrian "yEnS" Mato Gondelle
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;
var popupStatus1 = 0;
var popupStatus_jobcard = 0;
var popupStatus_cust = 0;
//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContact").fadeIn("slow");
		popupStatus = 1;
	}
}
function loadPopup1(){
	//loads popup only if it is disabled
	if(popupStatus1==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContact1").fadeIn("slow");
		popupStatus1 = 1;
	}
}



function loadPopup_jobcard(){
	//loads popup only if it is disabled
	
	if(popupStatus_jobcard==0){
		
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContact_jobcard").fadeIn("slow");
	
		popupStatus_jobcard = 1;
	}
}

function loadPopupcust(){
	//loads popup only if it is disabled
	if(popupStatus_cust==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContactcustomer").fadeIn("slow");
		popupStatus_cust = 1;
	}
}















//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact").height();
	var popupWidth = $("#popupContact").width();
	//centering
	$("#popupContact").css({
		"position": "absolute",
		"width":windowWidth
		//"top": windowHeight-popupHeight/2,
		//"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
	
}













function centerPopup1(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact1").height();
	var popupWidth = $("#popupContact1").width();
	//centering
	$("#popupContact1").css({
		"position": "absolute",
		"width":windowWidth
		//"top": windowHeight-popupHeight/2,
		//"left": windowWidth/2-popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
	
}





//CONTROLLING EVENTS IN jQuery
$(document).ready(function(){
	var counterPop = 1;
	//LOADING POPUP
	//Click the button event!
	
	$("#addButtonInUpdate").click(function(){
		counterPop=getPrevGridSize();
		counterPop--;
		var val=clearAllFields();
		//centering with css
		if(val==0){
		//centering with css
		centerPopup();
		//load popup
		loadPopup();
		$("#gridAddButton").hide("fast");
		$("#popUpAddButton").show("fast");
		}
	});
	
	$("#addButton").click(function(){
		var val=clearAllFields();
		if(val==0){
	    //centering with css
		centerPopup();
		//load popup
		loadPopup();
		$("#gridAddButton").hide("fast");
		$("#popUpAddButton").show("fast");
		}
	});
				

	
	//CLOSING POPUP
	//Click the x event!
	$("#popupContactClose").click(function(){
		disablePopup();
	});
	
	//Click out event!
	$("#backgroundPopup").click(function(){
		disablePopup();
		
	});
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
			popupStatus=0;
		}
	});
	
	/*$(document).keypress(function(e){
		if(e.keyCode==13 && popupStatus==0){
			loadPopup2();
			centerPopup2();
			popupStatus=1;
		}
	});*/
	
	
		
	$("#popUpAddButton").click(function () {
		var required=requiredField();
		if(required==0){
		addGrid(counterPop);
		counterPop++;
		}
		
	});
	
	
});