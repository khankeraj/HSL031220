$(document).ready(function(){
	
	 
       
          
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
        		$("#modelcode").autocomplete("GoogleSearch/ServiceModelCodeSearchStockModule.jsp");
        	  }catch(err){alert(err);}
          });
          $("#addRow").bind('click', addRows);
          
          function totalAmountCalculation(){
        	  var product_type = $("#product_type").val();
        	
        	  if(product_type=="Product_Finished_Goods")
        		  {
        		  var totalAmount=  Number(0);
            	  $('.item-row').each(function(i, row){
            		  try{ 
            		  var $quantity 	= $(row).find('#unitid');
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
            	  
            	
            	 // $('#grand_total').val(tt);
            	
             	 // alert("----tt----"+tt);
             	  var mathadi = parseFloat($("#mathadi").val());
             	 
             		
             		  var ss=Number(0);
             		
             		   ss=tt+mathadi;
             		  
             		//  $('#grand_total').val(ss);
             		 
             		  var other_exp = parseFloat($("#other_exp").val());
             		  var yy=Number(0);
             		 yy=ss+other_exp;
             		var new_num = Math.round(yy).toFixed(3);
             		 //alert("---yy-----"+yy);
             		 $('#grand_total').val(new_num);
        		  }
        	  
        	  
        	  if(product_type=="Spare_Finished_Goods")
    		  {
    	  var totalAmount=  Number(0);
    	  $('.item-row').each(function(i, row){
    		  try{ 
    		  var $quantity 	= $(row).find('#unitid');
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
    	  
    	
    	 // $('#grand_total').val(tt);
    	
     	 // alert("----tt----"+tt);
     	  var mathadi = parseFloat($("#mathadi").val());
     	 
     		
     		  var ss=Number(0);
     		
     		   ss=tt+mathadi;
     		  
     		//  $('#grand_total').val(ss);
     		 
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
                              
                              '<td style="width: 70px;"><input type="text" name="modelcode"  value=""  class="validate[required]"  id="modelcode"   style="width:150px;"/> </td>',
                              '<td style="width: 70px;"><input type="text" name="unitid" class="validate[required]" id="unitid" style="width: 150px;"  /></td>',
                              '<td style="width: 70px;"><input type="text" name="rate"  class="validate[required,custom[number]]"   id="rate"   style="width:100px;"/> </td>',
                              '<td style="width: 70px;"><input type="text" name="discount" class="validate[required,custom[number]]" value="" id="discount" style="width:100px;"  /></td>',
                              '<td style="width: 70px;"><input type="text" name="amount" class="validate[required,custom[number]]" value="" id="amount" style="width:100px;"  /></td>',
                           
                              '</tr>'
                              ].join('');
                              var $row = $($rowTemp);
                              $.currentRow = $row;

                              var $unitid 	        = $row.find('#unitid');
                              var $warranty	        = $row.find('#warranty');
                              var $rate 			 = $row.find('#rate');
                              var $discount 		 = $row.find('#discount');
                         
                              $last = $('#itemsTable').find('tbody tr:last');
                              $.first = $last.find('input:first');
                              if ( $.first.val() !== '' ) {
                                        
                            	  $row.find("#modelcode").autocomplete("GoogleSearch/ServiceModelCodeSearchStockModule.jsp");
																	
                            	  $($unitid).bind("change", function(){
                            		  //checkvalue($($unitid));
                                  });
                            	  
                            	  
                            	  $($rate).bind("keyup", function(){
                                	  totalAmountCalculation();
                                  });
                            	  
                            	  $($discount).bind("keyup", function(){
                            		
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
