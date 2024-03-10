// Convert numbers to words
// copyright 25th July 2006, by Stephen Chapman http://javascript.about.com
// permission to use this Javascript on your web page is granted
// provided that all of the code (including this copyright notice) is
// used exactly as shown (you can change the numbering system if you wish)

// American Numbering System
/*var th = ['','thousand','million','billion','trillion'];*/
// uncomment this line for English Number System
// var th = ['','thousand','million','milliard','billion'];

/*var dg = ['zero','one','two','three','four','five','six','seven','eight','nine'];
 var tn = ['ten','eleven','twelve','thirteen','fourteen','fifteen','sixteen','seventeen','eighteen','nineteen']; 
var tw = ['twenty','thirty','forty','fifty','sixty','seventy','eighty','ninety'];
 function toWords(s){s = s.replace(/[\, ]/g,''); if (s != parseFloat(s)) return 'not a number'; var x = s.indexOf('.'); if (x == -1) x = s.length; if (x > 15) return 'too big'; var n = s.split(''); var str = ''; var sk = 0; for (var i=0; i < x; i++) {if ((x-i)%3==2) {if (n[i] == '1') {str += tn[Number(n[i+1])] + ' '; i++; sk=1;} else if (n[i]!=0) {str += tw[n[i]-2] + ' ';sk=1;}} else if (n[i]!=0) {str += dg[n[i]] +' '; if ((x-i)%3==0) str += 'hundred ';sk=1;} if ((x-i)%3==1) {if (sk) str += th[(x-i-1)/3] + ' ';sk=0;}} if (x != s.length) {var y = s.length; str += 'point '; for (var i=x+1; i<y; i++) str += dg[n[i]] +' ';} return str.replace(/\s+/g,' ');}
*/




function numToString(x)
{
var r=0;
var txter=x;
var sizer=txter.length;
var numStr="";
if(isNaN(txter))
{
alert(" Invalid number");
exit();
}
var n=parseInt(x);
var places=0;
var str="";
var entry=0;
while(n>=1)
{
r=parseInt(n%10);

if(places<3 && entry==0)
{
numStr=txter.substring(txter.length-0,txter.length-3) // Checks for 1 to 999.
str=onlyDigit(numStr); //Calls function for last 3 digits of the value.
entry=1;
}

if(places==3)
{
numStr=txter.substring(txter.length-5,txter.length-3)
if(numStr!="")
{
str=onlyDigit(numStr)+ " Thousand "+str;
}
}

if(places==5)
{
numStr=txter.substring(txter.length-7,txter.length-5) //Substring for 5 place to 7 place of the string
if(numStr!="")
{
str=onlyDigit(numStr)+ " Lakhs "+str; //Appends the word lakhs to it
}
}

if(places==6)
{
numStr=txter.substring(txter.length-9,txter.length-7)  //Substring for 7 place to 8 place of the string
if(numStr!="")
{
str=onlyDigit(numStr)+ " Crores "+str;        //Appends the word Crores
}
}

n=parseInt(n/10);
places++;
}

//alert(str);
document.formID.rnum.value=str;


}




function onlyDigit(n)
{
//Arrays to store the string equivalent of the number to convert in words
var units=['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine'];
var randomer=['','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen'];
var tens=['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety'];
var r=0;
var num=parseInt(n);
var str="";
var pl="";
var tenser="";
while(num>=1)
{
r=parseInt(num%10);
tenser=r+tenser;
if(tenser<=19 && tenser>10) //Logic for 10 to 19 numbers
{
str=randomer[tenser-10];
}
else
{
if(pl==0)        //If units place then call units array.
{
str=units[r];
}
else if(pl==1)    //If tens place then call tens array.
{
str=tens[r]+" "+str;
}
}
if(pl==2)        //If hundreds place then call units array.
{
str=units[r]+" Hundred "+str;
}

num=parseInt(num/10);
pl++;
}
return str;
}

