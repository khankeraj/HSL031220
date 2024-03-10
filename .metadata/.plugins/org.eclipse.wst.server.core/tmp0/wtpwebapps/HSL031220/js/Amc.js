$(document).ready(function(){
                   $('#rate').bind("blur", function(){
        	  totalAmountCalculation();
          });
                   $('#qty').bind("blur", function(){
                 	  totalAmountCalculation();
                   });
         
       
          $('#vat').bind("blur", function(){
        	  try{
//        	  var vat_amt = ($('#total').val()/100) * $(this).val();
        	  var f = parseFloat($('#total').val())+parseFloat($(this).val()) +parseFloat($('#service_tax').val());
              $('#net_total').val(f);
        	  
        	 
//             totalAmount+= parseFloat($($amount).val());
        	  }catch(er){alert(er);}
        	  
          });
          $('#discount').bind("blur", function(){
        	  try{
//        	  var vat_amt = ($('#total').val()/100) * $(this).val();
        	  var total = parseFloat($('#total').val())+parseFloat($('#vat').val()) +parseFloat($('#service_tax').val());
        	  var amt_with_dis = total - ( (total/100) * parseFloat($(this).val()) );
              $('#net_total').val(amt_with_dis);
        	  
        	 
//             totalAmount+= parseFloat($($amount).val());
        	  }catch(er){alert(er);}
        	  
          });
          
          $('#paid_amt').bind("blur", function(){
                    $('#bal_amt').val( parseFloat($('#net_total').val()||0)- parseFloat($(this).val()||0));
          });

          totalAmountCalculation();
          
          function totalAmountCalculation(){
        	  try{
        	  var totalAmount=  Number(0);
        	  var service_tax=0;
        	  var vat=0;
        	  var net_total=2;
        	  var total=0;
        	  var bal=0;
        	  $('.item-row').each(function(i, row){
        		  try{ 
                  var $rate 	= parseFloat($(row).find('#rate').val()) || 0;
                  total +=$rate;
                  } 
                  catch(er){alert(er);}
        	  });
        	$('#total').val(total);
        	  service_tax = (total/100) * 70;
              service_tax = (service_tax/100) * 12.36;
              
              vat = (total / 100)*60;
              vat = (vat/100)*5;
              
              net_total =  total+ service_tax + vat;
              //alert('toatal:'+total+' service_tax '+ service_tax +' vat '+ vat+'');
        		var new_num = Math.round(service_tax).toFixed(2);
        	  $('#service_tax').val(new_num);
        	  
        	  new_num = Math.round(vat).toFixed(3);
        	  $('#vat').val(new_num);
        	  
        	  $('#net_total').val(net_total);
        	  
        	  bal = net_total - (parseFloat($('#paid_amt').val()) || 0);
        	  // $('#bal_amt')val(bal);
        	  }catch(err){alert(err);}
        	 
        	  
        	   
          }
          
          
          $("#addRow").bind('click', addRows);
          function addRows(e){
         	 try{
              	
                  var $itemsTable = $('#itemsTable');

                  var $rowTemp = [
                  '<tr class="item-row">',
                
                  '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                  
                  '<td style="width:70px;"><input type="text" name="modelcode"  value=""  class="tInput"  id="modelcode"   style="width:170px;"/> </td>',
                  '<td style=""><input type="text" name="unitid" class="tInput" value="" id="unitid" style="width: 150px;"  /></td>',
                  
                  '<td ><input type="text" name="time_period"  value=""  class="tInput"  id="time_period"   style="width:100px;"/> </td>',
                  '<td s><input type="text" name="no_of_services" class="tInput" value="" id="no_of_services" style="width:150px;"  /></td>',
                  '<td s><input type="text" name="rate" class="tInput" value="" id="rate" style="width:150px;"  /></td>',
                   
                  '</tr>'
                  ].join('');
                  var $row = $($rowTemp);
                  $.currentRow = $row;

                  var modelcode 	     = $row.find('#modelcode');
                  var rate = $row.find('#rate');
                  $last = $('#itemsTable').find('tbody tr:last');
                  $.first = $last.find('input:first');
                  if ( $.first.val() !== '' ) {
                	  
                	  $(modelcode).autocomplete("GoogleSearch/ServiceModelCodeSearchAmcModule.jsp");
                	  $(rate).bind("blur", totalAmountCalculation);
             	$('.item-row:last', $itemsTable).after($row);
                  } // End if last ItemName input is empty
         }catch(err){
                                       alert(err);
                             }
                             return false;
                   }


//                   $('#ItemName').focus(function(){
//                             window.onbeforeunload = function(){
//                                       return "You haven't saved your data.  Are you sure you want to leave this page without saving first?";
//                             };
//                   });

         }); // End DOM

         function addRowsFromSession(){
         	 try{
              	
                  var $itemsTable = $('#itemsTable');

                  var $rowTemp = [
                  '<tr class="item-row">',
                
                  '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                  
                  '<td style="width:70px;"><input type="text" name="modelcode"  value=""  class="tInput"  id="modelcode"   style="width:170px;"/> </td>',
                  '<td style=""><input type="text" name="unitid" class="tInput" value="" id="unitid" style="width: 150px;"  /></td>',
                  
                  '<td ><input type="text" name="time_period"  value=""  class="tInput"  id="time_period"   style="width:100px;"/> </td>',
                  '<td s><input type="text" name="no_of_services" class="tInput" value="" id="no_of_services" style="width:150px;"  /></td>',
                  '<td s><input type="text" name="rate" class="tInput" value="" id="rate" style="width:150px;"  /></td>',
                   
                  '</tr>'
                  ].join('');
                  var $row = $($rowTemp);
                  $.currentRow = $row;

                  $last = $('#itemsTable').find('tbody tr:last');
                  $.first = $last.find('input:first');
                  
                           
             	$('.item-row:last', $itemsTable).after($row);
                
         }catch(err){
                                       alert(err);
                             }
                             return false;
                   }

         // Remove row when clicked
         $("#deleteRow").live('click',function(){
                   $(this).parents('.item-row').remove();
                   // Hide delete Icon if we only have one row in the list.
                   if ($(".item-row").length < 2) $("#deleteRow").hide();
         });
