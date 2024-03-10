
$(document).ready(function(){
        
        $.currentRow = $('.item-row');
       
          $("tr").bind("keypress", function(event){
                    if(event.keyCode == 13){
                              addRows();
                    }

          });
         
          $('#rate').bind("keyup", function(){
        	  totalAmountCalculation();
          });

          $("#addRow").bind('click', addRows);
          
          function totalAmountCalculation(){
        	  var totalAmount=  Number(0);
        	  $('.item-row').each(function(i, row){
        		  try{ 
        		  var $quantity 	= $(row).find('#quntity');
                  var $rate 	= $(row).find('#rate');
                  var $amount 	= $(row).find('#amount');
               
                  var $quantity_value = $($quantity).val() * $($rate).val();
                 
                
                  $($amount).val(($quantity_value));
                  totalAmount+= parseFloat($($amount).val());
                
                  } 
                  catch(er){alert(er);}
        	  });
        	  $('#total1').val(totalAmount);
          }
          
          function addRows(e){
              try{
            	  
            	  //alert("s,sdm,fnsd,");
              	  var $itemsTable = $('#itemsTable');

                        var $rowTemp = [
                        '<tr class="item-row">',
                        '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                        '<td><input type="text" name="modelcode" class="validate[required,custom[integer]]" value="" id="modelcode"  style="width: 200px;"  /></td>',
                        '<td><input type="text" name="quntity" class="validate[required,custom[integer]]" value="" id="quntity"  style="width: 200px;"  /></td>',
                        '<td><input type="text" name="rate" class="validate[required,custom[integer]]" value="" id="rate"  style="width: 200px;"  /></td>',
                        '<td><input type="text" name="amount" class="validate[required,custom[integer]]" value="" id="amount"  style="width: 200px;"  /></td>',
                        '</tr>'
                        ].join('');
                        var $row = $($rowTemp);
                        $.currentRow = $row;
                       // var $brand 	        = $row.find('#brand');
                        var $product	    = $row.find('#modelcode');
                        var $rate 			 = $row.find('#rate');
                        $last = $('#itemsTable').find('tbody tr:last');
                        $.first = $last.find('input:first');
                        
                        
                        
                        
                      // alert("first"+$.first.val());
                        if ( $.first.val() !== '' ) {
                        	
                        	//$brand.autocomplete("GoogleSearch/Brand_Distributor_Master.jsp");
                      $product.autocomplete("GoogleSearch/ServiceModelCodeSearchAmcModule.jsp");
                      
                      $($rate).bind("keyup", function(){
                    	
                    	  totalAmountCalculation();
                      });

                                 $('.item-row:last', $itemsTable).after($row);
                        }
                        // End if last ItemName input is empty
              }
              
              catch(err){
                        alert(err);
              }
              return false;
    }

          
          
}); // End DOM

          function addRowsFromSession(){
        	  try{
              	
        		  
        		  
                  function totalAmountCalculation(){
                	  var totalAmount=  Number(0);
                	  $('.item-row').each(function(i, row){
                		  try{ 
                		  var $quantity 	= $(row).find('#quntity');
                          var $rate 	= $(row).find('#rate');
                          var $amount 	= $(row).find('#amount');
                       
                          var $quantity_value = $($quantity).val() * $($rate).val();
                         
                        
                          $($amount).val(($quantity_value));
                          totalAmount+= parseFloat($($amount).val());
                        
                          } 
                          catch(er){alert(er);}
                	  });
                	  $('#total1').val(totalAmount);
                  }
        		  
                  var $itemsTable = $('#itemsTable');

                  var $rowTemp = [
                                  '<tr class="item-row">',
                                  '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                                  '<td><input type="text" name="modelcode"  value=""  class="validate[required]"  id="modelcode"  style="width: 200px;"/> </td>',
                                  '<td><input type="text" name="quntity" class="validate[required,custom[integer]]" value="" id="quntity"  style="width: 200px;"  /></td>',
                                  '<td><input type="text" name="rate" class="validate[required,custom[integer]]" value="" id="rate"  style="width: 200px;"  /></td>',
                                  '<td><input type="text" name="amount" class="validate[required,custom[integer]]" value="" id="amount"  style="width: 200px;"  /></td>',
                                  '</tr>'
                                  ].join('');
                  var $row = $($rowTemp);
                  $.currentRow = $row;

                  var $product	    = $row.find('#modelcode');
                  var $rate 			 = $row.find('#rate');
                  $last = $('#itemsTable').find('tbody tr:last');
                  $.first = $last.find('input:first');
                if ( $.first.val() !== '' ) {
                	  $product.autocomplete("GoogleSearch/ServiceModelCodeSearchAmcModule.jsp");   
                	  $($rate).bind("keyup", function(){
                      	
                    	  totalAmountCalculation();
                      });
                	//  $product.autocomplete("GoogleSearch/productSearch_QuatationFormr.jsp");
                	   
                           $('.item-row:last', $itemsTable).after($row);
                 } // End if last ItemName input is empty
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
