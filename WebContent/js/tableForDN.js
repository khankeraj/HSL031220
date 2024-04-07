$(document).ready(function(){
	
	 ///alert('tbale for dn');
        
          $("tr").bind("keypress", function(event){
                   /* if(event.keyCode == 13){
                              addRows();
                    }*/

          });
          $('#rate').bind("keyup", function(){
        	  totalAmountCalculation();
          });

          $('#discount').bind("keyup", function(){
        	  totalAmountCalculation();
          });
          
          $('#vat').bind("keyup", function(){
        	  var vat_amt = ($('#total').val()/100) * $(this).val();
        	  var f = parseFloat($('#total').val())-parseFloat(vat_amt);
              $('#net_total').val( f);
//              totalAmount+= parseFloat($($amount).val());
        	  
          });
       
          $("#addRow").bind('click', addRows);
          function totalAmountCalculation(){
        	  var product_type = $("#item_type").val();
        	  
        	  if( product_type=="Semi-Finished Goods-product")
        	  {
        	  var totalAmount=  Number(0);
        	  var dis_amt=  Number(0);
        	  $('.item-row').each(function(i, row){
        		  try{ 
                  var $rate 	= $(row).find('#rate');
                  var $discount = $(row).find('#discount');
                  var $amount	= $(row).find('#amount');
                   dis_amt = ($($rate).val()/100) * $($discount).val();
                //  var amount = parseFloat($('#total').val())+parseFloat(vat_amt)
                  $($amount).val(parseFloat($($rate).val()) + dis_amt);
                  totalAmount+= parseFloat($($amount).val());
                  } 
                  catch(er){alert(er);}
        	  });
        		var new_num = Math.round(totalAmount).toFixed(3);
        	  $('#total').val(new_num);
          }
        	  
        	  if(product_type=="Finished Goods-spare" || product_type=="Semi-Finished Goods-spare" || product_type=="Finished Goods-product")
        	  {
        	  var totalAmount=  Number(0);
        	  var dis_amt=  Number(0);
        	  $('.item-row').each(function(i, row){
        		  try{ 
        		 var $quantity 	= $(row).find('#unitid_srno');
                  var $rate 	= $(row).find('#rate');
                  var $discount = $(row).find('#discount');
                  var $amount	= $(row).find('#amount');
                  
                  var $quantity_value = $($quantity).val() * $($rate).val();
                  
                   dis_amt = (($quantity_value)/100) * $($discount).val();
                  // alert(dis_amt);
                //  var amount = parseFloat($('#total').val())+parseFloat(vat_amt)
                   
                  // $($amount).val(($quantity_value)-dis_amt);
                   
                  $($amount).val(($quantity_value) + dis_amt);
                  totalAmount+= parseFloat($($amount).val());
                  } 
                  catch(er){alert(er);}
        	  });
        		var new_num = Math.round(totalAmount).toFixed(3);
        	  $('#total').val(new_num);
          }
        	  if( product_type=="Finished Goods-product")
        	  {
        		 // alert("ssss");
        	  var totalAmount=  Number(0);
        	  var dis_amt=  Number(0);
        	  $('.item-row').each(function(i, row){
        		  try{ 
        		 var $quantity 	= $(row).find('#unitid_srno');
                  var $rate 	= $(row).find('#rate');
                  var $discount = $(row).find('#discount');
                  var $amount	= $(row).find('#amount');
                  
                  var $quantity_value = $($quantity).val() * $($rate).val();
                  
                   dis_amt = (($quantity_value)/100) * $($discount).val();
                  // alert(dis_amt);
                //  var amount = parseFloat($('#total').val())+parseFloat(vat_amt)
                   
                  // $($amount).val(($quantity_value)-dis_amt);
                   
                  $($amount).val(($quantity_value) + dis_amt);
                  totalAmount+= parseFloat($($amount).val());
                  } 
                  catch(er){alert(er);}
        	  });
        		var new_num = Math.round(totalAmount).toFixed(3);
        	  $('#total').val(new_num);
          }
        	   
          }
          
          $('#item_type').bind('change', function(){
        	  try{
        		
        	  $('#itemsTable tr:gt(1)').each(function(index){
        		 // alert('tr');
        		  $(this).remove();
        	  });
        	// alert($('td' < '#modelcode').val());
        	
        	  }catch(err){alert(err);}
          });
          
          
 function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              
                              '<td><input type="text" name="model_spare"  value=""  class="validate[required]"  id="model_spare"/> </td>',
                              '<td><input type="text" name="unitid_srno" class="validate[required]" value="" id="unitid_srno" /></td>',
                              '<td><input type="text" name="warranty" class="validate[required,custom[number]]" value="" id="warranty" /></td>',
                              '<td><input type="text" name="rate" class="validate[required,custom[number]]" value="" id="rate" /></td>',
                              '<td><input type="text" name="discount" class="validate[required,custom[number]]" value="" id="discount" /></td>',
                              '<td><input type="text" name="amount" class="validate[required,custom[number]]" value="" id="amount" /></td>',
                           
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;

                              var $model_spare 	     = $row.find('#model_spare');
                              var $model_spare 	     = $row.find('#model_spare');
                            //  var $item_type	     = $row.find('#item_type').val();
                              var $unitid_srno       = $row.find('#unitid_srno');
                              var $rate 			 = $row.find('#rate');
                              var $discount 		 = $row.find('#discount');
                              
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                           
                              if ( $.first.val() !== '' ) {
                            	  var item_type = $("#item_type").val();
                            	  
                            	  $model_spare.autocomplete("GoogleSearch/ModelCode_Search_Delivery_Note_Module.jsp");
                            	  
                            	  
                            	  
                            	  
                            	  if(item_type=='Finished Goods-product')
                            	  {  
                            		 // alert("-------");
                            	  //$unitid_srno.autocomplete("GoogleSearch/Unitid_Sr_NO_SearchDeliveryNoteModule.jsp");
                            	
                            	  }
                            	  try{
                            	  $($unitid_srno).bind("change", function(){
                            		 // alert("ssss");
                            		  checkvalue($($unitid_srno));
                                  });
                            	  
                            	  }
                            	  catch (e) {
  									alert(e);
  								}
                            	  
                            	 /* if(item_type=='Finished Goods-spare')
                            	  {
                            		  alert("-------");
                            		  $($unitid_srno).bind("keypress", function(){
                            			  isNumber($($unitid_srno));
                                      });
                            	  }*/
                            	  
                            	  
                            	  
                            	  
                            	  if(item_type=='Semi-Finished Goods-product')
                            	  {
                            		  //alert("-------");
                            	  $unitid_srno.autocomplete("GoogleSearch/Unitid_Sr_NO_SearchDeliveryNoteModule.jsp");
                            	  }
                            	  
                            	 
                            	  
                            	  
                            	  
                            	
                            	  $($rate).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });
                            	  
                            	  
                            	
                            	  
                            	  $($discount).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });
                                 
                            	
                            	

                                       /* $row.bind("keypress", function(event){
                                                  if(event.keyCode == 13){
                                                            addRows();
                                                  }

                                        });*/
                                       
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
