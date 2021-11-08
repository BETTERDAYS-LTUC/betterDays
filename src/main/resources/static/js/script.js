

let form =document.getElementById("form");
     form.addEventListener('submit',snedReply);
      function snedReply(event){
         event.preventDefault();
         let from_name=event.target.name.value;
         let message=event.target.message.value;
         let email=event.target.email.value;
         let phone =event.target.phone.value;
         let para={
         from_name,message,email,phone
          }
          emailjs.send("service_ngpzqkl","template_1y0xo0k",para);
          document.getElementById('form').reset()

     }


