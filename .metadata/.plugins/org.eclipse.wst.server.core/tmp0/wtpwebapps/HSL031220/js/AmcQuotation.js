$(document).ready(function(){
                   $('#rate').bind("keyup", function(){
        	  totalAmountCalculation();
          });
                   $('#qty').bind("keyup", function(){
                 	  totalAmountCalculation();
                   });
         
       
          $('#vat').bind("keyup", function(){
        	  try{
        	  var vat_amt = ($('#total').val()/100) * $(this).val();
        	  var f = parseFloat($('#total').val())+parseFloat(vat_amt)
              $('#net_total').val( f);
//              totalAmount+= parseFloat($($amount).val());
        	  }catch(er){alert(er);}
        	  
          });

          $('#PurchasePrice').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#Quantity').val());
          });

       
          function totalAmountCalculation(){
        	  var totalAmount=  Number(0);
        	  var service_tax;
        	  var vat;
        	  var net_total;
        	  $('.item-row').each(function(i, row){
        		  try{ 
                  var $rate 	= $(row).find('#rate');
                  var $qty		= $(row).find('#qty');
                  var $amount	= $(row).find('#amount');
                  $($amount).val($($rate).val() * $($qty).val());
                  totalAmount+= parseFloat($($amount).val());
                  service_tax = (totalAmount/100) * 70;
                  service_tax = (service_tax/100) * 12.36;
                  vat = (totalAmount / 100)*60;
                  vat = (vat/100)*5;
                  net_total =  totalAmount + service_tax + vat;
                  } 
                  catch(er){alert(er);}
        	  });
        		var new_num = Math.round(service_tax).toFixed(2);
        	  $('#service_tax').val(new_num);

        	  new_num = Math.round(vat).toFixed(3);
        	  $('#vat').val(new_num);
        	  
        	  $('#net_total').val(net_total);
        	   
          }
          
          $("#addRow").bind('click', addRows);
 function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              
                              '<td style=""><input type="text" name="modelcode"  value=""  class="tInput"  id="modelcode"   style="width:250px;"/> </td>',
                              '<td style=""><input type="text" name="rate"  value=""  class="tInput"  id="rate"   style="width:100px;"/> </td>',
                              '<td style=""><input type="text" name="qty"  value=""  class="tInput"  id="qty"   style="width:100px;"/> </td>',
                              '<td style=""><input type="text" name="amount" class="tInput" value="" id="amount" style="width:100px;"  /></td>',
                           
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;

                              var $model_spare 	     = $row.find('#model_spare');
                              var $qty      		 = $row.find('#qty');
                              var $rate 			 = $row.find('#rate');
                              
                              
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                            	  
                            	  $($rate).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });
                            	  
                            	  $($qty).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });

                            	  
                                 
																	
                            	

                                      
                                       
                                        // Add row after the first row in table
                                       
                         	$('.item-row:last', $itemsTable).after($row);
                              } // End if last ItemName input is empty
                    }catch(err){
                              alert(err);
                    }
                    return false;
          }


//          $('#ItemName').focus(function(){
//                    window.onbeforeunload = function(){
//                              return "You haven't saved your data.  Are you sure you want to leave this page without saving first?";
//                    };
//          });

}); // End DOM

// Remove row when clicked
$("#deleteRow").live('click',function(){
          $(this).parents('.item-row').remove();
          // Hide delete Icon if we only have one row in the list.
          if ($(".item-row").length < 2) $("#deleteRow").hide();
});
