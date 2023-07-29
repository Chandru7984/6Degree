document.getElementById("signinForm").addEventListener("submit", function (event) {
  event.preventDefault();

  // Get signin form values
  const email = document.getElementById('email').value ;
  const password = document.getElementById('password').value ;
  // const name = document.getElementById('name').value;

  const data = {
    email: email,
    password: password,
    // name: name
  };

  const  apidata  =null;

  // Make API call to signin endpoint
  // Replace API_ENDPOINT with your actual API endpoint
   fetch("http://localhost:8080/signin", {
    // mode: "no-cors",
    method: "POST",
    body: JSON.stringify(data),
    headers: {
      "Content-Type": "application/json",
      // "Authorization": "API_KEY"
    }
  })
    .then(async function (response) {
      console.log(response);
     this.apidata = await response.json();

      console.log( "data" ,this.apidata)
      if (response.status == 200) {
        // document.getElementById("message").textContent = "Signin successful";
        window.location.href = "http://127.0.0.1:5500/welcome.html?name=" + encodeURIComponent(this.apidata.name);
      } else if(this.apidata.email != email && this.apidata.password != password) {
        document.getElementById("message").textContent = "Invalid Credentials";
      }
    } 
      )
    .catch(function (error) {

      document.getElementById("message").textContent = "Signin failed";
    });
});


// .then(function(response) {
//   if (response.ok) {
//     return response.json();
//   } else {
//     throw new Error("Invalid username or password.");
//   }
// })
// .then(function(data) {
//   // Handle successful signin response
//   // You can perform additional actions here, such as redirecting to a dashboard page
//   console.log("Signin successful:", data);
// })
// .catch(function(error) {
//   // Handle signin error
//   console.error("Signin failed:", error);
// });
// });

