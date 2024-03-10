var dtCh= "/";
var minYear=1900;
var maxYear=2100;

function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strDay=dtStr.substring(0,pos1)
	var strMonth=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		alert("The date format should be : dd/mm/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		alert("Please enter a valid month")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day")
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		alert("Please enter a valid date")
		return false
	}
return true
}

function ValidateForm(dt){
	
      if(dt.value=="")
{

return true;
}			 
else if(dt.value.length<10)
	{
	alert("Enter Date in dd/mm/yy format Only.")
	dt.value = "";
	
    window.setTimeout(function ()
    {
        dt.focus();
    }, 0);
    return false;
	
	}





	if (isDate(dt.value)==false){
		dt.value = "";
	
    window.setTimeout(function ()
    {
        dt.focus();
    }, 0);
    return false;
	}
    return true
 }

function FixShortDate(txtBox) {
        if (txtBox == null) { 
           return '' }
     
      var re = new RegExp(/(\d{6})(\d{2})?/);
    
     if (re.test(txtBox.value))
      {
           if (txtBox.value.length == 8) {
             txtBox.value = txtBox.value.substring(0, 2) + '/' + txtBox.value.substring(2, 4) + '/' + txtBox.value.substring(4, 8)
          }
          
         if (txtBox.value.length == 6) {
               if (txtBox.value.substring(4, 6) < 60)
              {
                 txtBox.value = txtBox.value.substring(0, 2) + '/' + txtBox.value.substring(2, 4) + '/20' + txtBox.value.substring(4, 6);
               }
              else
              {
                   txtBox.value = txtBox.value.substring(0, 2) + '/' + txtBox.value.substring(2, 4) + '/19' + txtBox.value.substring(4, 6);
              }
           }
       }
       return txtBox.value;
  }
 
function setColon(elm)
{

var strTime = elm.value 
var strTimeL = strTime.length
if(isNaN(strTime))
{
//if(strTimeL>4)
//{
  if(strTimeL==5)
  {
  var h=strTime.substring(0,2);
  var m=strTime.substring(3,5);
  var c=strTime.substring(2,3);
 // alert("hr "+h+"  min "+m+" s "+c)
  if(isNaN(h) || isNaN(m) || c!==':')
  {
  alert("Enter Valid Time in hhmm format.");
	  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return true;
  }
  }
 
//*************(((((((((((((((((((((((((((((
else
{
//////////////////////////////////////////////////////
alert("Enter Valid Time in hhmm format.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
}
}
 else if(strTimeL>4)
  {
  // greater than 4
  alert("Enter Valid Time in hhmm format.");
	  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
  
  
  
  
  // greater than 4 
  }
else if(strTimeL==3)
{
alert("Sorry, Please enter time either in Single digit,\n Double digit or in Four digit.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
}
else if(strTimeL==1)
{
elm.value='0'+strTime.substr(0,1) + ':00'
}
else if(strTimeL==2)
{
  if(strTime>23)
  {
  alert("Sorry, Wrong Time");
  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
  }
  else
elm.value=strTime.substr(0,2) + ':00'
}

else if (strTimeL==4)
{
if(strTime.substr(0,2)>24 || strTime.substr(2,4)>59)
{
alert("Sorry, Invalid Time.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
}
else
elm.value = strTime.substr(0,2) + ':' + strTime.substr(2,4)
}
//document.getElementById("shifttime").value=document.getElementById("starttime").value

var t1=document.getElementById("starttime").value;
var t2=document.getElementById("endtime").value;
 if(t1=='' || t2=='')
 {
  document.getElementById("total_time").value="00:00";
//document.getElementById("extrahrs").focus();
 //return false;
 }




}




function coloneh(elm)
{
var strTime = elm.value 
var strTimeL = strTime.length
if(isNaN(strTime))
{
//if(strTimeL>4)
//{
  if(strTimeL==5)
  {
  var h=strTime.substring(0,2);
  var m=strTime.substring(3,5);
  var c=strTime.substring(2,3);
 // alert("hr "+h+"  min "+m+" s "+c)
  if(isNaN(h) || isNaN(m) || c!==':')
  {
  alert("Enter Valid Time in hhmm format.");
	  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return true;
  }
  }
 
//*************(((((((((((((((((((((((((((((
else
{
//////////////////////////////////////////////////////
alert("Enter Valid Time in hhmm format.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
}
}
 else if(strTimeL>4)
  {
  // greater than 4
  alert("Enter Valid Time in hhmm format.");
	  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
  
  
  
  
  // greater than 4 
  }
else if(strTimeL==3)
{
alert("Sorry, Please enter time either in Single digit,\n Double digit or in Four digit.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
}
else if(strTimeL==1)
{
elm.value='0'+strTime.substr(0,1) + ':00'
}
else if(strTimeL==2)
{
 /* if(strTime>23)
  {
  alert("Sorry, Wrong Time");
  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
  }
  else */
elm.value=strTime.substr(0,2) + ':00'
}

else if (strTimeL==4)
{
if( strTime.substr(2,4)>59 )
{
alert("Sorry, Invalid Time.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
}
else
elm.value = strTime.substr(0,2) + ':' + strTime.substr(2,4)
}


////////////////////////////////////////////
///////////////////////
/////////////////////////



}

//////////////////////////////////////////////////////

function setColonet(elm)
{

var strTime = elm.value 
var strTimeL = strTime.length
if(isNaN(strTime))
{
//if(strTimeL>4)
//{
  if(strTimeL==5)
  {
  var h=strTime.substring(0,2);
  var m=strTime.substring(3,5);
  var c=strTime.substring(2,3);
 // alert("hr "+h+"  min "+m+" s "+c)
  if(isNaN(h) || isNaN(m) || c!==':')
  {
  alert("Enter Valid Time in hhmm format.");
	  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return true;
  }
  }
 
//*************(((((((((((((((((((((((((((((
else
{
//////////////////////////////////////////////////////
alert("Enter Valid Time in hhmm format.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
}
}
 else if(strTimeL>4)
  {
  // greater than 4
  alert("Enter Valid Time in hhmm format.");
	  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
  
  
  
  
  // greater than 4 
  }
else if(strTimeL==3)
{
alert("Sorry, Please enter time either in Single digit,\n Double digit or in Four digit.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
}
else if(strTimeL==1)
{
elm.value='0'+strTime.substr(0,1) + ':00'
 var t1=document.getElementById("starttime").value;
	 var t2=document.getElementById("endtime").value;
      if(t1=='' || t2=='')
	  {
	   document.getElementById("total_time").value="00:00";
	 document.getElementById("extrahrs").focus();
	  return false;
	  }
	 // alert(t1  +"------"+t2)
	var h1=t1.substring(0,2);
	var m1=t1.substring(3,5);
	var h2=t2.substring(0,2);
	var m2=t2.substring(3,5);
	//alert(h1 +"--"+m1+"   "+h2 +"--"+m2)
	 var hr=h2-h1;
	 if(hr<0)
	 {
	 hr=hr+24;
	 }
	 var min=m2-m1;
	 if(min<0)
	 {
	 min=60+min;
	 hr=hr-1;
	 }
	 var nhr=""+hr;
	 var nmin=""+min;
	 // var len=hr.length
	 //alert(len)
	 if(nhr.length==1)
	 {
	 hr="0"+hr;
	 }
	 if(nmin.length==1)
	 {
	 
	 min="0"+min;
	 }
	 var ntime=hr+":"+min;
	// alert(hr  +": "+min)
	// alert(ntime)
	 
	 document.getElementById("total_time").value=ntime;
	 document.getElementById("extrahrs").focus();
}
else if(strTimeL==2)
{
  if(strTime>23)
  {
  alert("Sorry, Wrong Time");
  elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
  }
  else
  {
elm.value=strTime.substr(0,2) + ':00'
 var t1=document.getElementById("starttime").value;
	 var t2=document.getElementById("endtime").value;
      if(t1=='' || t2=='')
	  {
	   document.getElementById("total_time").value="00:00";
	 document.getElementById("extrahrs").focus();
	  return false;
	  }



	 // alert(t1  +"------"+t2)
	var h1=t1.substring(0,2);
	var m1=t1.substring(3,5);
	var h2=t2.substring(0,2);
	var m2=t2.substring(3,5);
	//alert(h1 +"--"+m1+"   "+h2 +"--"+m2)
	 var hr=h2-h1;
	 if(hr<0)
	 {
	 hr=hr+24;
	 }
	 var min=m2-m1;
	 if(min<0)
	 {
	 min=60+min;
	 hr=hr-1;
	 }
	 var nhr=""+hr;
	 var nmin=""+min;
	 // var len=hr.length
	 //alert(len)
	 if(nhr.length==1)
	 {
	 hr="0"+hr;
	 }
	 if(nmin.length==1)
	 {
	 
	 min="0"+min;
	 }
	 var ntime=hr+":"+min;
	// alert(hr  +": "+min)
	// alert(ntime)
	 
	 document.getElementById("total_time").value=ntime;
	 document.getElementById("extrahrs").focus();

}


}

else if (strTimeL==4)
{
if(strTime.substr(0,2)>24 || strTime.substr(2,4)>59)
{
alert("Sorry, Invalid Time.");
elm.value="";
window.setTimeout(function ()
    {
        elm.focus();
    }, 0);
return false;
}
else
{
elm.value = strTime.substr(0,2) + ':' + strTime.substr(2,4)
 var t1=document.getElementById("starttime").value;
	 var t2=document.getElementById("endtime").value;
      if(t1=='' || t2=='')
	  {
	   document.getElementById("total_time").value="00:00";
	 document.getElementById("extrahrs").focus();
	  return false;
	  }



	 // alert(t1  +"------"+t2)
	var h1=t1.substring(0,2);
	var m1=t1.substring(3,5);
	var h2=t2.substring(0,2);
	var m2=t2.substring(3,5);
	//alert(h1 +"--"+m1+"   "+h2 +"--"+m2)
	 var hr=h2-h1;
	 if(hr<0)
	 {
	 hr=hr+24;
	 }
	 var min=m2-m1;
	 if(min<0)
	 {
	 min=60+min;
	 hr=hr-1;
	 }
	 var nhr=""+hr;
	 var nmin=""+min;
	 // var len=hr.length
	 //alert(len)
	 if(nhr.length==1)
	 {
	 hr="0"+hr;
	 }
	 if(nmin.length==1)
	 {
	 
	 min="0"+min;
	 }
	 var ntime=hr+":"+min;
	// alert(hr  +": "+min)
	// alert(ntime)
	 
	 document.getElementById("total_time").value=ntime;
	 document.getElementById("extrahrs").focus();
}
}


}








 