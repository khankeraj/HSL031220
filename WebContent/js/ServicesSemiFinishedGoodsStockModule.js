$(document).ready(function(){
        
        
        // alert('hiiii');
          $('#Quantity').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#PurchasePrice').val());
          });

          $('#PurchasePrice').bind("keyup", function(){
                    $('#TotalAmt').val( $(this).val() * $('#Quantity').val());
          });
          $('#rate').bind("keyup", function(){
        	  totalAmountCalculation();
          });
          
          $('#discount').bind("keyup", function(){
        	  totalAmountCalculation();
          });
          
          $('#mathadi').bind("keyup", function(){
        	
        	  totalAmountCalculation();
          });
          
          
          $('#vat').bind("keyup", function(){
        	  totalAmountCalculation();
        	  
          });
          
          $('#other_exp').bind("keyup", function(){
        	  totalAmountCalculation();
        	  
          });
          
          $('#product_type').bind('change', function(){
        	  try{
        	  $('#itemsTable tr:gt(1)').each(function(index){
        		 // alert('tr');
        		  $(this).remove();
        	  });
        	// alert($('td' < '#modelcode').val());
        	 $("#modelcode").unbind();
        		$("#modelcode").autocomplete("GoogleSearch/ServiceModelCodeSearchSemiStockModule.jsp");
        	  }catch(err){alert(err);}
          });
          
          

          $("#addRow").bind('click', addRows);

          function totalAmountCalculation(){
        	  var product_type = $("#product_type").val();
          	
        	  if(product_type=="Product_Semi_Finished_Goods")
        		  {
        	  var totalAmount=  Number(0);
        	  $('.item-row').each(function(i, row){
        		  try{ 
                  var $rate 	= $(row).find('#rate');
                  var $discount = $(row).find('#discount');
                  var $amount	= $(row).find('#amount');
                  var dis_amt = ($($rate).val()/100) * $($discount).val();
                  $($amount).val($($rate).val()-dis_amt);
                  totalAmount+= parseFloat($($amount).val());
                  } 
                  catch(er){alert(er);}
        	  });
        	  $('#total').val(totalAmount);
        	  
        	  var vat = parseFloat($("#vat").val());
        	  var vat_amt = ($('#total').val()/100) *vat;
        	  var tt=  Number(0);
        	 tt=totalAmount+vat_amt;
        	  
        	
        	  $('#grand_total').val(tt);
        	
         	 // alert("----tt----"+tt);
         	  var mathadi = parseFloat($("#mathadi").val());
         	 
         		
         		  var ss=Number(0);
         		
         		   ss=tt+mathadi;
         		  
         		  $('#grand_total').val(ss);
         		 
         		  var other_exp = parseFloat($("#other_exp").val());
         		  var yy=Number(0);
         		 yy=ss+other_exp;
         		var new_num = Math.round(yy).toFixed(3);
         		 //alert("---yy-----"+yy);
         		 $('#grand_total').val(new_num);
        		  }
        	  
        	  
        	  if(product_type=="Spare_Semi_Finished_Goods")
    		  {
    	  var totalAmount=  Number(0);
    	  $('.item-row').each(function(i, row){
    		  try{ 
    		  var $quantity 	= $(row).find('#quantity');
              var $rate 	= $(row).find('#rate');
              var $discount = $(row).find('#discount');
              var $amount	= $(row).find('#amount');
           
              var $quantity_value = $($quantity).val() * $($rate).val();
             
              var dis_amt = (($quantity_value)/100) * $($discount).val();
         
              $($amount).val(($quantity_value)-dis_amt);
           
              totalAmount+= parseFloat($($amount).val());
            
              } 
              catch(er){alert(er);}
    	  });
    	 // $('#grand_total').val(totalAmount);
    	  $('#total').val(totalAmount);
    		
    	 
    	  //alert(totalAmount.val());
    	  var vat = parseFloat($("#vat").val());
    	  var vat_amt = ($('#total').val()/100) *vat;
    	  var tt=  Number(0);
    	 tt=totalAmount+vat_amt;
    	  
    	
    	  $('#grand_total').val(tt);
    	
     	 // alert("----tt----"+tt);
     	  var mathadi = parseFloat($("#mathadi").val());
     	 
     		
     		  var ss=Number(0);
     		
     		   ss=tt+mathadi;
     		  
     		  $('#grand_total').val(ss);
     		 
     		  var other_exp = parseFloat($("#other_exp").val());
     		  var yy=Number(0);
     		 yy=ss+other_exp;
     		var new_num = Math.round(yy).toFixed(3);
     		 //alert("---yy-----"+yy);
     		 $('#grand_total').val(new_num);
    		  }
        	 
          }
          
          
          
          function addRows(e){
                    try{
                    	
                              var $itemsTable = $('#itemsTable');

                              var $rowTemp = [
                              '<tr class="item-row">',
                            
                              '<td><a id="deleteRow"><img src="images/icon-minus.png" alt="Remove Item" title="Remove Item"></a></td>',
                              
                              '<td style="width: 70px;"><input type="text" name="modelcode"    id="modelcode" class="validate[required]"   style="width:150px;"/> </td>',
                              
                              
                              '<td style="width: 70px;"><input type="text" name="quantity"  value=""    id="quantity" class="validate[required]"   style="width:150px;"/> </td>',
                              '<td style="width: 70px;"><select name="condition" id="condition" class="validate[required]"><option value="">-----------select-----------</option><option value="Working">Working</option><option value="Not Working">Not Working</option> <option value="Not Working">Scrap</option>  </select></td> ',
                              
                              '<td style="width: 70px;"><input type="text" name="rate"  value="0"    id="rate" class="validate[required,custom[number]]" style="width:100px;"/> </td>',
                              '<td style="width: 70px;"><input type="text" name="discount" value="0" id="discount" class="validate[required,custom[number]]"  style="width:100px;"  /></td>',
                              
                              '<td style="width: 70px;"><input type="text" name="amount"  value="0" id="amount" class="validate[required,custom[number]]"  style="width:100px;"  /></td>',
                           
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;
//                              $.currentRow.find('#ItemName').val('value');
                              // save reference to inputs within row
                              var $sub_product 	        = $row.find('#sub_product');
                              var $serial_no 	        = $row.find('#quantity');
                              var $rate 			 = $row.find('#rate');
                              var $discount 		 = $row.find('#discount');
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                                        
                            	
                             	  $row.find("#modelcode").autocomplete("GoogleSearch/ServiceModelCodeSearchSemiStockModule.jsp");


                                        
                                  	  
                                  	  $($rate).bind("keyup", function(){
                                      	  totalAmountCalculation();
                                        });
                                  	  
                                  	  $($discount).bind("keyup", function(){
                                      	  totalAmountCalculation();
                                        });
                                        
                                        $($serial_no).bind("change", function(){
                                  		  checkvalue($($serial_no));
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
