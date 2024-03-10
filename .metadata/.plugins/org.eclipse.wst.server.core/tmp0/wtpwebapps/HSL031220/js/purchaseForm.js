$(document).ready(function(){
        
         
          $("tr").bind("keypress", function(event){
                    if(event.keyCode == 13){
                              addRows();
                    }

          });
          $('#Quantity').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#PurchasePrice').val());
          });

          $('#PurchasePrice').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#Quantity').val());
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
        	  $('#total').val(totalAmount);
          }

          function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              '<td><input type="text" name="pfb.description"  value=""  cssClass="validate[required]"  id="description"  style="width: 150px;"/> </td>',
                              '<td><input type="text" name="pfb.rate" cssClass="validate[required,custom[number]]" value="" id="rate"  style="width: 150px;"  /></td>',
                              '<td><input type="text" name="pfb.qty" cssClass="validate[required,custom[integer]]" value="" id="qty"  style="width: 150px;"  onblur="calculateBill(this);" /></td>',
                              '<td><input type="text" name="pfb.amt" cssClass="validate[required]"  value="" id="amt"  style="width: 150px;" readonly="readonly"  /></td>',
                             
                              
                              
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;
//                              $.currentRow.find('#ItemName').val('value');
                              // save reference to inputs within row
                              
                              // auto search
                              
                             /* var $description = $($row).find('#description');
                              $($description).autocomplete("dscription_amt_auto_search.jsp");
                              */
                              
                              //end......
                            
                              var $rate 			 = $row.find('#rate');
                              
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                                        
                            	
                                   
                            	  $($rate).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });

                                       
                                        // Add row after the first row in table
                                       
                                        $('.item-row:last', $itemsTable).after($row);
                                       // $($sub_product).focus();
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
