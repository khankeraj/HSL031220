/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function numeralsOnly() {
       var evt = (evt) ? evt : event;
     
        var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
        	           ((evt.which) ? evt.which : 0));
        alert("-----"+charCode)

        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
           alert("Enter numerals only in this field.");
           return false;
          }
           return true;
   }