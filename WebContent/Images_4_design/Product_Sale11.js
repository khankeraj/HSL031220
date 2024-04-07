$(document).ready(function(){
          $("#addRow").bind('click', addRows);
 function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td><a id="deleteRow"><img src="Images_4_design/AddRowDataTable/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              
                            
                             '<td><input type="text" name="product_name"  value="" class="validate[required]"  id="product_name" onblur="product_info(this);duplicate(this);"  /></td>',
                             '<td><input type="text" name="unit_no"  value=""  class="validate[required]"  id="unit_no"/> </td>',
                             '<td><input type="text" name="qty"  value="" class="validate[required]"  id="qty" onblur="netamt(this);" /></td>',
                             '<td><input type="text" name="price"  value="" class="validate[required]"  id="price"  /></td>',
                             '<td style="border:1px;"><input type="text" name="iw_period"  value="" class="validate[required]"  id="iw_period" /></td>',
                             '<td style="border:1px;"><input type="text" name="product_expiry_date"  value="" class="validate[required]"  id="product_expiry_date"/></td>',
                             
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;
                              
                              var $pcode     = $row.find('#product_name');
                              $($pcode).autocomplete("GoogleSearch/product_name_master_auto_search.jsp");
                                var $model_spare 	     = $row.find('#model_spare');
                            //  var $item_type	     = $row.find('#item_type').val();
                              var $unitid_srno       = $row.find('#unitid_srno');
                            //  var $unitid_srno       = $row.find('#unitid_srno');
                              var $rate 			 = $row.find('#rate');
                              var $discount 		 = $row.find('#discount');
                              
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if (true ) {
                            	  $($model_spare).autocomplete("site_code_auto_search.jsp");
                                        // Add row after the first row in table
                            	            
                         	$('.item-row:last', $itemsTable).after($row);
                         	 $('.tInputmodel_spare').autocomplete("site_code_auto_search.jsp"); 
                         	
                              }// End if last ItemName input is empty
                              else
                       		 {
                       		 $('.item-row:last', $itemsTable).after($row);
                       		 $('.tInputmodel_spare').autocomplete("AutoSearch/location_search.jsp");
                        	 $($model_spare).focus();
                       		 }
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              $($model_spare).bind("blur", function(){
                            	  fillKilometer(this);
                                   });
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
f11();