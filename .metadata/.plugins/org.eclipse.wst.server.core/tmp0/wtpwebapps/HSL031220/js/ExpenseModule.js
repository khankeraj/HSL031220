$(document).ready(function(){
                   $('#amt').bind("blur", function(){
        	  totalAmountCalculation();
          });
       
          function totalAmountCalculation(){
        	  var totalAmount=  Number(0);
        	  var service_tax;
        	  var vat;
        	  var net_total;
        	  $('.item-row').each(function(i, row){
        		  try{ 
                  var $amt 	= $(row).find('#amt');
                
                  totalAmount+= parseFloat($($amt).val());
                
                  } 
                  catch(er){alert(er);}
        	  });
        		var totalAmount = Math.round(totalAmount).toFixed(2);
        	
        	  
        	  $('#total').val(totalAmount);
        	   
          }
          
          $("#addRow").bind('click', addRows);
 function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              
                              '<td style=""><input type="text" name="purpose"  value=""  class="tInput"  id="purpose"   style="width:250px;"/> </td>',
                              '<td style=""><input type="text" name="amt"  value=""  class="tInput"  id="amt"   style="width:100px;"/> </td>',
                           
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;

                              var $model_spare 	     = $row.find('#model_spare');
                              var $amt 			 = $row.find('#amt');
                              
                              
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                            	  
                            	  $($amt).bind("blur", function(){
                                	  totalAmountCalculation();
                                  });
                            	  
                            	                                        
                                       
                         	$('.item-row:last', $itemsTable).after($row);
                              } // End if last ItemName input is empty
                    }catch(err){
                              alert(err);
                    }
                    return false;
          }




}); // End DOM

// Remove row when clicked
$("#deleteRow").live('click',function(){
          $(this).parents('.item-row').remove();
          // Hide delete Icon if we only have one row in the list.
          if ($(".item-row").length < 2) $("#deleteRow").hide();
});
