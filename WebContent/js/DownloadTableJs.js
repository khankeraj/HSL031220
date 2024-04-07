/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
  $("#ItemsTable > tbody").find("tr").bind("dblclick",function(){
            ValueGo($(this));

  });
                                       //   alert($(this).text());
                             
 $("#ItemsTable > tbody").find("tr").bind("keydown",  function(event){
                                                  ValueGo();
                              });
    function ValueGo(value){

//              alert(value.find('td:first').text());
              $("#tempValues").val(value.find('td:first').text());
$("#DownloadPurchaseOrderAction").submit();

    }

});