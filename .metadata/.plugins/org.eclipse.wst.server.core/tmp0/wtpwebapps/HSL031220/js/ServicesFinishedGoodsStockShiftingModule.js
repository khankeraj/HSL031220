$(document).ready(function(){
	
	 //alert("ssssssss");
         // $('#Quantity').bind("keypress", isNumber);
          $("tr").bind("keypress", function(event){
                   /* if(event.keyCode == 13){
                              addRows();
                    }*/

          });
          $('#Quantity').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#PurchasePrice').val());
          });

          $('#PurchasePrice').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#Quantity').val());
          });

         
          $('#item_type').bind('change', function(){
        	  try{
        	  $('#itemsTable tr:gt(1)').each(function(index){
        		 // alert('tr');
        		  $(this).remove();
        	  });
        	// alert($('td' < '#modelcode').val());
        	 
        	  }catch(err){alert(err);}
          });
          
          
          
          $("#addRow").bind('click', addRows);
 function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td style="width:10px;"><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" style="width:10px;" title="Remove Item"></a></td>',
                              
                              '<td style="width: 70px;"><input type="text" name="model_spare"  value=""  class="validate[required]"  id="model_spare"  /> </td>',
                              '<td style="width: 70px;"><input type="text" name="unitid_quantity" class="validate[required]"  id="unitid_quantity"   /></td>',
                              
                              '<td style="width: 70px;"><input type="text" name="amount" class="validate[required,custom[number]]" value="" id="amount"   /></td>',
                           
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;

                              var $sub_product 	        = $row.find('#sub_product');
                              var $warranty	        = $row.find('#warranty');
                              var $model_spare       = $row.find('#model_spare');
                              var $unitid_srno       = $row.find('#unitid_quantity');
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                                        
                            	  $row.find("#model_spare").autocomplete("GoogleSearch/Stock_Shifting.jsp");
																	
                              	  var item_type = $("#item_type").val();
                              	  if(item_type=='Finished Goods-product')
                              		  {
                             	  $row.find("#unitid_quantity").autocomplete("GoogleSearch/Stock_Shifting_uniitid.jsp");
                              		  }
                              	  
                              	  if(item_type=='Semi-Finished Goods-product')
                          		  {
                         	  $row.find("#unitid_quantity").autocomplete("GoogleSearch/Stock_Shifting_uniitid.jsp");
                          		  }
                              	  
                              	  $($unitid_srno).bind("change", function(){
                            		  checkvalue($($unitid_srno));
                                  });
                             	
                                        // Add row after the first row in table
                                       
                             	
                             	  
                                        $('.item-row:last', $itemsTable).after($row);
                                        $($sub_product).focus();
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
