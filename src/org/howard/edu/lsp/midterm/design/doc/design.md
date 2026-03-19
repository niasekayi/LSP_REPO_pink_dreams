Class: Order  
Responsibilities: store order data, calculate total  
Collaborators: none  

Class: ReceiptPrinter  
Responsibilities: display receipt to user  
Collaborators: Order  

Class: FileStorage  
Responsibilities: save order data to a file  
Collaborators: Order  

Class: EmailService  
Responsibilities: send confirmation emails  
Collaborators: Order  

Class: DiscountService  
Responsibilities: apply discount rules  
Collaborators: Order  

Class: Logger  
Responsibilities: log system activity  
Collaborators: none  